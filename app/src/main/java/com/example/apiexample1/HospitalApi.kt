package com.example.apiexample1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HospitalApi {
    @GET("get_divisions")
    fun getPopularMovies() : Call<Hospital>
}