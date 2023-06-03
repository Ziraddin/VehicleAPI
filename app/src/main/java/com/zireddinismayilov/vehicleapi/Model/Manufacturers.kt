package com.zireddinismayilov.vehicleapi.Model

data class Manufacturers(
    var Country: String,
    var Mfr_CommonName: String,
    var Mfr_ID: Int,
    var Mfr_Name: String,
    var VehicleTypes: List<VehicleTypes>
)
