package viewmodel

import android.util.Log

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.test.ApiInterface
import com.sample.test.RetrofitClient
import di.RetroModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel: ViewModel() {
    private var userDataList:  MutableLiveData<UserData> = MutableLiveData()

    // lateinit var retroModule: ApiInterface
   var retroModule: RetroModule = RetroModule()


    fun getLiveDataObserver(): MutableLiveData<UserData>{

        return  userDataList
    }


    fun makeAPIcall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retrofitClient = RetrofitClient.getClient()?.create(ApiInterface::class.java)

            val res =
                retrofitClient?.getUserDataDummy("2")

            res?.enqueue(object : Callback<UserData> {
                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    if (response.isSuccessful) {
                        when {
                            response.body() != null -> {
                                Log.e("TAG", "Res--" + response.body())

                                userDataList.value = response.body()!!
                            }

                        }
                    }

                }

                override fun onFailure(call: Call<UserData>, t: Throwable) {

                }
            })
        }

    }

   /* fun makeAPIcall(): Result<Events<UserData?>> {
        val res: Result<Events<UserData?>>? =
            retroModule.getRetroFitClientInstance()?.create(ApiInterface::class.java)?.getUserData("2")

         return try {

            Result(Status.SUCCESS, res?.data, null)

        }catch (e: Exception){

            Result(Status.ERROR, null, null)
        }
    }*/
}