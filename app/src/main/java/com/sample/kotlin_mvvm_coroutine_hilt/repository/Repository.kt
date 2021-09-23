package com.sample.kotlin_mvvm_coroutine_hilt.repository

import coil.request.Disposable
import com.sample.kotlin_mvvm_coroutine_hilt.module.RemoteDataSource
import com.sample.kotlin_mvvm_coroutine_hilt.response.DogResponse
import com.sample.kotlin_mvvm_coroutine_hilt.utils.BaseApiResponse
import com.sample.kotlin_mvvm_coroutine_hilt.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource): BaseApiResponse() {

    //For Dog image API call
    suspend fun getDogData(): Flow<NetworkResult<DogResponse>>{
        return flow<NetworkResult<DogResponse>> {
            emit(safeApiCall { remoteDataSource.getDogSource() })

        }.flowOn(Dispatchers.IO)
    }

}