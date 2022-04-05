package com.example.lrapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lrapp.api.UserService
import com.example.lrapp.models.User
import com.example.lrapp.models.UserX
import retrofit2.Response

class UserRespository(private val userService: UserService) {

    private val userLiveData = MutableLiveData<User>()
    val users : LiveData<User>
    get()=userLiveData

    suspend fun getUser(){
        val result =userService.getUser()
        if(result.body()!=null){
            userLiveData.postValue(result.body())
        }
    }
}