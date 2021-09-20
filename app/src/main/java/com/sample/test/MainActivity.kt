package com.sample.test

import adapter.RecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import model.UserData

import viewmodel.MainActivityViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageFromLogin = intent.extras?.getString("EXTRA_MESSAGE") ?: "Message is NULL from Login"
        //Note:
        // here "?:" means like else. (If null values, it shows "Message is NULL from Login" )
        // For testing try to comment putExtra from loginScreen.

        title_textview.text = messageFromLogin

        initRecyclerView()
        initViewModel()

    }

   private fun initRecyclerView() {
        recyclerview.layoutManager = LinearLayoutManager(this)
       var decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerview.addItemDecoration(decoration)
        recyclerViewAdapter = RecyclerViewAdapter()
       recyclerview.adapter =  recyclerViewAdapter

       mainActivityViewModel = MainActivityViewModel()
    }

    private fun initViewModel() {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)

        mainActivityViewModel.makeAPIcall()
        mainActivityViewModel.getLiveDataObserver().observe(this, object : Observer<UserData> {
            override fun onChanged(t: UserData?) {
                if (t != null) {

                    recyclerViewAdapter.setUpdatedData(t.data)
                    recyclerViewAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity, "Error in getting data", Toast.LENGTH_SHORT).show()
                }
            }

        })



      /*val res: Result<Events<UserData?>> = mainActivityViewModel.makeAPIcall()
        Log.e("TAG", "Res--"+res.status)*/

    }
}
