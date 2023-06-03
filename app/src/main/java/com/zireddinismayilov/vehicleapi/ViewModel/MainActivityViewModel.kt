package com.zireddinismayilov.vehicleapi.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zireddinismayilov.vehicleapi.Model.Results
import com.zireddinismayilov.vehicleapi.Retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var result = MutableLiveData<Results>()

    fun getallmanufacturers(context: Context) {
        RetrofitInstance.instance.getallmanufacturers("json")?.enqueue(object : Callback<Results?> {
            override fun onResponse(call: Call<Results?>, response: Response<Results?>) {
                result.postValue(response.body())
            }

            override fun onFailure(call: Call<Results?>, t: Throwable) {
                Toast.makeText(context, "Error has occured!", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun observeResult(): MutableLiveData<Results> {
        return result
    }

}