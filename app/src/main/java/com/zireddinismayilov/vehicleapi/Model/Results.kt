package com.zireddinismayilov.vehicleapi.Model

import java.io.Serializable

data class Results(
    var Count: Int,
    var Results: List<Manufacturers>
) : Serializable
