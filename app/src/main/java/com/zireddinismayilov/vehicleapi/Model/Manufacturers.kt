package com.zireddinismayilov.vehicleapi.Model

import java.io.Serializable

data class Manufacturers(
    var Country: String,
    var Mfr_CommonName: String,
    var Mfr_ID: Int,
    var Mfr_Name: String,
    var Address: String,
    var ContactEmail: String,
    var ContactPhone: String,
    var VehicleTypes: List<VehicleTypes>
) : Serializable
