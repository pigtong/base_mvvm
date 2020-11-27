package com.example.basemvvm.data.source.remote

import com.example.basemvvm.data.model.HolidayCard
import com.example.basemvvm.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ExampleApiService {

    @GET("cards")
    fun getHolidayCards(): Call<List<HolidayCard>>

    @GET("profile")
    fun getUserProfile(): Call<User>
}