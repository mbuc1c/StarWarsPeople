package com.mbucic.starwarspeople

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbucic.starwarspeople.model.StarWarsCharacter
import com.mbucic.starwarspeople.view.PeopleAdapter

@BindingAdapter("app:items")
fun setItems(recyclerView: RecyclerView, items: List<StarWarsCharacter>?) {
    items?.let {
        val adapter = PeopleAdapter(items)
        recyclerView.adapter = adapter
    }
}