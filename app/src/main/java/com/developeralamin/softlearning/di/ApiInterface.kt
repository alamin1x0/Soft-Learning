package com.developeralamin.softlearning.di

import com.developeralamin.softlearning.model.category.CategoryModel
import com.developeralamin.softlearning.model.post.PostModel
import com.developeralamin.softlearning.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(Constants.END_POINT + Constants.POST)
    suspend fun getPost(): Response<PostModel>

    @GET(Constants.END_POINT + Constants.CATEGORY)
    suspend fun getCategory(): Response<CategoryModel>

    @GET(Constants.END_POINT + Constants.POST)
    suspend fun getPostByCategory(
        @Query(Constants.CATEGORY) category: String
    ): Response<PostModel>
}