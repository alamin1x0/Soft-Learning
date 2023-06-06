package com.developeralamin.softlearning.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developeralamin.softlearning.model.category.CategoryModel
import com.developeralamin.softlearning.model.post.PostModel
import com.developeralamin.softlearning.repository.PostRepository
import com.developeralamin.softlearning.utils.NetworkResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    val postLiveData: LiveData<NetworkResults<PostModel>>
        get() = postRepository.postLiveData

    val categoryLiveData: LiveData<NetworkResults<CategoryModel>>
        get() = postRepository.categoryLiveData

    fun getPost() {
        viewModelScope.launch {
            postRepository.getPost()
        }
    }

    fun getCategory() {
        viewModelScope.launch {
            postRepository.getCategory()
        }
    }

    fun getCategoryByPost(categoryId: String) {
        viewModelScope.launch {
            postRepository.getPostByCategory(categoryId)
        }
    }
}