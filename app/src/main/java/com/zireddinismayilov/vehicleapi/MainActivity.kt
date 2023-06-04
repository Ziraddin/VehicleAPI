package com.zireddinismayilov.vehicleapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zireddinismayilov.vehicleapi.Adapter.ManufacturersAdapter
import com.zireddinismayilov.vehicleapi.ViewModel.MainActivityViewModel
import com.zireddinismayilov.vehicleapi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.getManufacturersRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.getallmanufacturers(this)
        Handler().postDelayed({
            binding.progressBar.visibility = View.GONE
            viewModel.observeResult().observe(this, Observer {
                binding.resultsCount.text = it.Count.toString() + " results have found"
                binding.getManufacturersRecyclerView.adapter =
                    ManufacturersAdapter(it, object : ManufacturersAdapter.OnItemClickListener {
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@MainActivity, ItemDetails::class.java)
                            intent.putExtra("Item", it.Results[position])
                            startActivity(intent)
                        }

                    })
            })
        }, 3000)
        binding.getManufacturersRecyclerView.visibility = View.VISIBLE
    }
}
