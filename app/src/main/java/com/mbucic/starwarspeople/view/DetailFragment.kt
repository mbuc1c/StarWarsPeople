package com.mbucic.starwarspeople.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.mbucic.starwarspeople.databinding.FragmentDetailBinding
import com.mbucic.starwarspeople.viewmodel.PeopleViewModel

class DetailFragment : Fragment() {

    private val viewModel: PeopleViewModel by activityViewModels()

    private var binding: FragmentDetailBinding? = null

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = this@DetailFragment.viewModel
            selectedItemIndex = args.index
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        Log.d("myTag", "Detail Fragment view destroyed!")
    }
}