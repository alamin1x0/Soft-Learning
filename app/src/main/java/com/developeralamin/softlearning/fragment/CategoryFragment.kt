package com.developeralamin.softlearning.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.developeralamin.softlearning.adapter.CategoryAdapter
import com.developeralamin.softlearning.databinding.FragmentCategoryBinding
import com.developeralamin.softlearning.interfacs.CategoryClick
import com.developeralamin.softlearning.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment(), CategoryClick {

    private lateinit var binding: FragmentCategoryBinding
    private val postViewModel by viewModels<PostViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater)


        postViewModel.getCategory()

        postViewModel.categoryLiveData.observe(requireActivity()) {
            binding.recyclerViewId.adapter = CategoryAdapter(requireContext(), it.data!!, this)
            binding.progressBar.visibility = View.GONE

            Log.d("SAKIB", "onCreateView: ${it.data}")
        }

        return binding.root
    }

    override fun onCategoryClick(category: String) {

        val direction = CategoryFragmentDirections.actionCategoryFragmentToCategoryPostFragment(category)

        findNavController().navigate(direction)
    }

}