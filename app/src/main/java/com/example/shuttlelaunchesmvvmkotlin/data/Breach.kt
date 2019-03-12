package com.example.shuttlelaunchesmvvmkotlin.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class Breach (@SerializedName( "name") val name: String,
    @SerializedName("BreachDate")val breachDate: String,
    @SerializedName("Description")val description: String)