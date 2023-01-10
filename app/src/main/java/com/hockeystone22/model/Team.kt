package com.hockeystone22.model


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("cc")
    val cc: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image_id")
    val imageİd: String,
    @SerializedName("name")
    val name: String
)