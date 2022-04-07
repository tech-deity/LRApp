package com.example.lrapp.api

import com.example.lrapp.models.User
import com.example.lrapp.models.UserX
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

     @GET("/fetchuser.php")
     suspend fun getUser():Response<User>

}

