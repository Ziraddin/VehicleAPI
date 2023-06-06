package com.zireddinismayilov.vehicleapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.NumberPicker
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zireddinismayilov.vehicleapi.Adapter.ManufacturersAdapter
import com.zireddinismayilov.vehicleapi.Model.Results
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

        showAllManufacturers()
        searchViewOnChange()
    }


    fun ManufacturersAdapterSetUp(it: Results): ManufacturersAdapter {

        return ManufacturersAdapter(it, object : ManufacturersAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, ItemDetails::class.java)
                intent.putExtra("Item", it.Results[position])
                startActivity(intent)
            }

        })
    }


    fun showAllManufacturers() {


        viewModel.observeResult().observe(this, Observer {
            binding.getManufacturersRecyclerView.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            Handler().postDelayed({
                binding.progressBar.visibility = View.GONE
                binding.resultsCount.text = it?.Count?.toString() + " results have found"
                binding.getManufacturersRecyclerView.adapter = ManufacturersAdapterSetUp(it)
            }, 400)
            binding.getManufacturersRecyclerView.visibility = View.VISIBLE
        })
    }

    fun searchViewOnChange() {
        binding.SearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                viewModel.getDataByManufacturerName(this@MainActivity, p0.toString())
                binding.SearchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0.toString().length == 0) {
                    binding.SearchView.clearFocus()
                    viewModel.getallmanufacturers(this@MainActivity)
                }
                return true
            }
        })
    }

}
