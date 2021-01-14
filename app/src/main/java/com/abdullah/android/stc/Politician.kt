package com.abdullah.android.stc

import com.google.gson.annotations.SerializedName

data class Politician (
    val name:String,
    val role:String,
    val team:String,
    val address:String,
    val zipCode:String,
    val city:String,
    val country:String,
    val email:String,
    @SerializedName("Party") val admin:String,

)

data class Objects(
    val objects:List<Politician>
)