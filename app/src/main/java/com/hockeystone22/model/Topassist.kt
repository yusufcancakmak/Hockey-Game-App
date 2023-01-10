package com.hockeystone22.model


import com.google.gson.annotations.SerializedName

data class Topassist(
    @SerializedName("assists")
    val assists: String,
    @SerializedName("matches")
    val matches: String,
    @SerializedName("player")
    val player: PlayerX,
    @SerializedName("team")
    val team: Team
)