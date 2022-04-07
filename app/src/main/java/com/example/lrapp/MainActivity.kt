package com.example.lrapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lrapp.api.RetrofitHelper
import com.example.lrapp.api.UserService
import com.example.lrapp.models.User
import com.example.lrapp.models.UserX
import com.example.lrapp.repository.UserRespository
import com.example.lrapp.viewmodel.MainViewModel
import com.example.lrapp.viewmodel.MainViewModelFactory
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: UserAdapter
    lateinit var rv: RecyclerView
    private lateinit var user: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userService = RetrofitHelper.getInstance().create(UserService::class.java)
        val respository = UserRespository(userService)

        adapter = UserAdapter(user.users)
        rv = findViewById(R.id.user_r_v)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        mainViewModel = ViewModelProvider(
            this, MainViewModelFactory(respository)
        ).get(MainViewModel::class.java)
        mainViewModel.users.observe(this) {

            adapter.setUserList(it.users)


        }
    }

}
