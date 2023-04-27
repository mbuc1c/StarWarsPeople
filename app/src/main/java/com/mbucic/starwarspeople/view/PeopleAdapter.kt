package com.mbucic.starwarspeople.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mbucic.starwarspeople.databinding.PersonViewItemBinding
import com.mbucic.starwarspeople.model.StarWarsCharacter

class PeopleAdapter(
    private val people: List<StarWarsCharacter>
) : RecyclerView.Adapter<PeopleAdapter.PersonViewHolder>() {
    class PersonViewHolder(private var binding: PersonViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(character: StarWarsCharacter?) {
            binding.name.text = character?.name ?: "No bueno"
            binding.root.setOnClickListener {
                val action = PeopleFragmentDirections.actionPeopleFragmentToDetailFragment(index = adapterPosition)
                it.findNavController().navigate(action)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = PersonViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(people[position])
    }
}
