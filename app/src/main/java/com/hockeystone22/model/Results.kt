package com.hockeystone22.model


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("topassists")
    val topassists: List<Topassist>,
    @SerializedName("topgoals")
    val topgoals: List<Topgoal>
)