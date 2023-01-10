package com.hockeystone22.model


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("results")
    val results: Results,
    @SerializedName("success")
    val success: Int
)