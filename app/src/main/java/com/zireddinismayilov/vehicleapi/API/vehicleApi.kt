package com.zireddinismayilov.vehicleapi.API

import com.zireddinismayilov.vehicleapi.Model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface vehicleApi {

    @GET("getallmanufacturers")
    fun getallmanufacturers(@Query("format") format: String): Call<Results?>?
}