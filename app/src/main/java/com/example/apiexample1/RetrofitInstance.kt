package com.example.apiexample1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: HospitalApi by lazy {

        Retrofit.Builder()
            .baseUrl("https://zulekhahospitals.com/zapi/public/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HospitalApi::class.java)


    }

}