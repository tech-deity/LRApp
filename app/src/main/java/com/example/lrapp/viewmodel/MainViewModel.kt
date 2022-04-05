package com.example.lrapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lrapp.models.User
import com.example.lrapp.models.UserX
import com.example.lrapp.repository.UserRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val userRespository: UserRespository) :ViewModel() {
    init {
        viewModelScope.launch (Dispatchers.IO){
            userRespository.getUser()
        }
    }
    val users :LiveData<User>
    get()=userRespository.users
}