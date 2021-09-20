package com.sample.test


import model.UserData
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import utils.Events
import utils.Result


interface ApiInterface {
    @Headers("Accept: application/json")
    @POST("auth/login")
    fun userLogin(@Body generalRequest: GeneralRequest): Call<JSONObject>

    /*@GET("users")
    fun getUserData(@Query("page")page: String): Call<UserData?>*/

    @GET("users")
    fun getUserData(@Query("page")page: String): Result<Events<UserData?>>

    @GET("users")
    fun getUserDataList(@Query("page")page: String): Response<UserData?>

    @GET("users")
    fun getUserDataDummy(@Query("page")page: String): Call<UserData>
}