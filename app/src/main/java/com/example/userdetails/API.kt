package com.example.userdetails

import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("users")
    fun getData():Call<List<UsersDataItem>>
}