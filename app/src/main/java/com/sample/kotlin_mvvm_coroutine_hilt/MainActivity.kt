package com.sample.kotlin_mvvm_coroutine_hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import coil.load
import coil.transform.RoundedCornersTransformation
import com.sample.kotlin_mvvm_coroutine_hilt.databinding.ActivityMainBinding
import com.sample.kotlin_mvvm_coroutine_hilt.response.DogResponse
import com.sample.kotlin_mvvm_coroutine_hilt.utils.NetworkResult
import com.sample.kotlin_mvvm_coroutine_hilt.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private  val mainViewModel by viewModels<MainViewModel>()
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        fetchData()
    }

    private fun fetchData() {
        mainViewModel.fetchDogResponse()

        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    //bind data to the view

                    activityMainBinding.imageView.load(response.data?.message) {
                        transformations(RoundedCornersTransformation(16f))
                    }
                }
                is NetworkResult.Error -> {
                    //Show error message
                }
                is NetworkResult.Loading -> {
                    //show progress bar
                }


            }

        }

    }


}