package com.zireddinismayilov.vehicleapi.Retrofit

import com.zireddinismayilov.vehicleapi.API.vehicleApi
import com.zireddinismayilov.vehicleapi.Constant.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val instance = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(vehicleApi::class.java)
}