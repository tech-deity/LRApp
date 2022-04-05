package com.example.lrapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lrapp.repository.UserRespository

class MainViewModelFactory(private val userRespository: UserRespository):ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(userRespository) as T
    }

}