package com.hockeystone22.model


import com.google.gson.annotations.SerializedName

data class Topgoal(
    @SerializedName("goal_points")
    val goalPoints: String,
    @SerializedName("goals")
    val goals: String,
    @SerializedName("matches")
    val matches: String,
    @SerializedName("minutes_played")
    val minutesPlayed: String,
    @SerializedName("penalties")
    val penalties: String,
    @SerializedName("player")
    val player: PlayerX,
    @SerializedName("substituted_in")
    val substitutedİn: String,


)