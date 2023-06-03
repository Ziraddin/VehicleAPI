package com.zireddinismayilov.vehicleapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.zireddinismayilov.vehicleapi.Adapter.ManufacturersAdapter
import com.zireddinismayilov.vehicleapi.ViewModel.MainActivityViewModel
import com.zireddinismayilov.vehicleapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.getManufacturersRecyclerView.layoutManager = GridLayoutManager(this, 1)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.getallmanufacturers(this)
        viewModel.observeResult().observe(this, Observer {
            binding.getManufacturersRecyclerView.adapter = ManufacturersAdapter(it)
        })
    }
}