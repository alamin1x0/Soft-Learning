package com.developeralamin.softlearning.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.developeralamin.softlearning.adapter.PostAdapter
import com.developeralamin.softlearning.databinding.FragmentCategoryPostBinding
import com.developeralamin.softlearning.viewmodel.PostViewModel

class CategoryPostFragment : Fragment() {

    lateinit var binding: FragmentCategoryPostBinding

    private val postViewModel by viewModels<PostViewModel>()

    private val args : CategoryPostFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCategoryPostBinding.inflate(layoutInflater)

        postViewModel.getCategoryByPost(args.categroy!!)

        postViewModel.postLiveData.observe(requireActivity()) {
            binding.recyclerViewId.adapter = PostAdapter(requireContext(), it.data!!)
            binding.progressBar.visibility = View.GONE

            Log.d("SAKIB", "onCreateView: ${it.data}")
        }

        return binding.root
    }
}