package com.example.apiexample1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalViewModel : ViewModel() {

    private var hospitalLiveData = MutableLiveData<List<Data>>()

    fun getPopularHospital() {
        RetrofitInstance.api.getPopularMovies().enqueue(
            object : Callback<Hospital> {
                override fun onResponse(call: Call<Hospital>, response: Response<Hospital>) {
                    if (response.body() != null) {
                        hospitalLiveData.value = response.body()!!.data
                    } else {
                        return
                    }
                }

                override fun onFailure(call: Call<Hospital>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }

    fun observeHospitalLiveData(): LiveData<List<Data>> {
        return hospitalLiveData
    }


}