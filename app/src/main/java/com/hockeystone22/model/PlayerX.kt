package com.hockeystone22.model


import com.google.gson.annotations.SerializedName

data class PlayerX(
    @SerializedName("cc")
    val cc: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)