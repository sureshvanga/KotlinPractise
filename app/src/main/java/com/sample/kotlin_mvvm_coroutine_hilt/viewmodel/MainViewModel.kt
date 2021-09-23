package com.sample.kotlin_mvvm_coroutine_hilt.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.sample.kotlin_mvvm_coroutine_hilt.repository.Repository
import com.sample.kotlin_mvvm_coroutine_hilt.response.DogResponse
import com.sample.kotlin_mvvm_coroutine_hilt.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private  val repository: Repository, application: Application): AndroidViewModel(application) {


    private val _response: MutableLiveData<NetworkResult<DogResponse>> = MutableLiveData()

    //This response should be public for calling Activity class.
      val response : LiveData<NetworkResult<DogResponse>> =  _response


    fun fetchDogResponse() = viewModelScope.launch {
        repository.getDogData().collect { value -> _response.value = value  }
    }


}