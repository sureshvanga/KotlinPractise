package com.sample.kotlin_mvvm_coroutine_hilt.interfaces

import com.sample.kotlin_mvvm_coroutine_hilt.response.DogResponse
import com.sample.kotlin_mvvm_coroutine_hilt.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET(Constants.RANDOM_URL)
    suspend fun getDog(): Response<DogResponse>

}