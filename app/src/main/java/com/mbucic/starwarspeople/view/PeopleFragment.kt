package com.mbucic.starwarspeople.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbucic.starwarspeople.R
import com.mbucic.starwarspeople.databinding.FragmentPeopleBinding
import com.mbucic.starwarspeople.viewmodel.PeopleViewModel

class PeopleFragment : Fragment() {

    private val viewModel: PeopleViewModel by activityViewModels()

    private var binding: FragmentPeopleBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentPeopleBinding.inflate(inflater)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = this@PeopleFragment.viewModel
        }

        viewModel.people.observe(viewLifecycleOwner) { people ->
            val adapter = PeopleAdapter(people)
            binding?.recyclerView?.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}