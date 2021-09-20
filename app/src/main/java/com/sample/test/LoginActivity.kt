package com.sample.test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_activity.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
       // private val TAG = LoginActivity::class.java.simpleName
        private const val TAG = "LoginActivity"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        initView()


    }

    private fun initView() {

        btn_submit.setOnClickListener (this)
        btn_reset.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_submit -> {
                val username: String = et_user_name.text.toString()
                val password: String = et_password.text.toString()

                Toast.makeText(this, "Values: $username/$password", Toast.LENGTH_SHORT).show()

                Log.e(TAG, "UserName: $username, Password: $password")
                if(username.isNotEmpty() && password.isNotEmpty()){
                    //callApiService(username,password)
                    val intent = Intent(this, MainActivity::class.java).apply {
                       putExtra("EXTRA_MESSAGE", "Message From Login")
                    }
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()

                }
            }
            R.id.btn_reset -> {
                et_user_name.setText("")
                et_password.setText("")
            }
        }
    }

    private fun callApiService(username: String, password: String) {
        val retrofitClient = RetrofitClient.getClient()?.create(ApiInterface::class.java)
        val generalRequest = GeneralRequest(
            username.trim { it <= ' ' },
            password.trim { it <= ' ' }
        )

        val loginResponse= retrofitClient?.userLogin(generalRequest)
        loginResponse?.enqueue(object : Callback<JSONObject> {
            override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                when {
                    response.body() != null -> {
                        Log.e("TAG", "Res--"+response.body())

                    }
                    response.code() == 401 -> {
                    }

                }
            }

            override fun onFailure(call: Call<JSONObject>, t: Throwable) {

            }
        })

    }

}