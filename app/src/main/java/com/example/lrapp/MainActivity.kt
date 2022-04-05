package com.example.lrapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.lrapp.api.RetrofitHelper
import com.example.lrapp.api.UserService
import com.example.lrapp.repository.UserRespository
import com.example.lrapp.viewmodel.MainViewModel
import com.example.lrapp.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userService = RetrofitHelper.getInstance().create(UserService::class.java)
        val respository = UserRespository(userService)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(respository)).get(MainViewModel::class.java)
        mainViewModel.users.observe(this) {
            Log.d("MESSAGE", it.users.toString())
        }


    }
}