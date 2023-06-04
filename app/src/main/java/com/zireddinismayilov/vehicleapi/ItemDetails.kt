package com.zireddinismayilov.vehicleapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zireddinismayilov.vehicleapi.Adapter.ManufacturersItemDetailsAdapter
import com.zireddinismayilov.vehicleapi.Model.Manufacturers
import com.zireddinismayilov.vehicleapi.databinding.ActivityItemDetailsBinding

class ItemDetails : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.itemDetailsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var itemDetails = intent.getSerializableExtra("Item") as Manufacturers


        binding.CountryItemNameItemDetails.setText("Country : " + itemDetails.Country)
        binding.CommonNameNameItemDetails.setText("CommonName : " + itemDetails.Mfr_CommonName)
        binding.NameItemDetails.setText("Name : " + itemDetails.Mfr_Name)
        if (itemDetails.VehicleTypes.size > 0) {
            binding.isPrimaryTVItemDetails.setText("IsPrimary")
            binding.nameTVItemDetails.setText("Name")
            binding.itemDetailsRecyclerView.adapter =
                ManufacturersItemDetailsAdapter(itemDetails.VehicleTypes)
        } else {
            binding.isPrimaryTVItemDetails.setText("There are no details about vehicle types")
            binding.isPrimaryTVItemDetails.setTextColor(getColor(R.color.errorColor))
            binding.nameTVItemDetails.setText("")
        }
    }
}