package com.mbucic.starwarspeople.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mbucic.starwarspeople.model.StarWarsCharacter
import com.mbucic.starwarspeople.network.StarWarsApi
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {
    private val _people = MutableLiveData<List<StarWarsCharacter>>()
    val people: LiveData<List<StarWarsCharacter>> = _people

    init {
        getStarWarsCharacters()
    }

    private fun getStarWarsCharacters() {
        viewModelScope.launch {
            val peopleList = mutableListOf<StarWarsCharacter>()
            var nextPage = 1
            while(nextPage != 0) {
                try {
                    val result = StarWarsApi.retrofitService.getPeople("$nextPage")
                    peopleList.addAll(result.results)
                    nextPage += 1
                    if (result.next == null) {
                        nextPage = 0
                    }
                } catch (e: Exception) {
                    _people.value = listOf()
                }
            }
            _people.value = peopleList
            Log.d("MyTag", "Size of people list: ${_people.value?.size}")
            for (person in _people.value!!) {
                Log.d("MyTag", person.name)
            }
        }
    }
}