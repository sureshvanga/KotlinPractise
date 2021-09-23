package com.sample.kotlin_mvvm_coroutine_hilt.module

import com.sample.kotlin_mvvm_coroutine_hilt.interfaces.ApiServices
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiServices: ApiServices) {


//Note: Suspend function should be called only from a coroutine or another suspend function

    //For Dog image API call
    suspend fun getDogSource() = apiServices.getDog()

}