package com.example.apiexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apiexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: HospitalViewModel
    private lateinit var movieAdapter : HospitalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[HospitalViewModel::class.java]
        viewModel.getPopularHospital()
        viewModel.observeHospitalLiveData().observe(this, Observer { movieList ->
            movieAdapter.setHospitalList(movieList)
        })

    }

    private fun prepareRecyclerView() {
        movieAdapter = HospitalAdapter()
        binding.rvHospital.apply {
            layoutManager = GridLayoutManager(applicationContext,2)
            adapter = movieAdapter
        }
    }
}