package com.hockeystone22.service

import com.hockeystone22.helper.Contants
import com.hockeystone22.model.Player
import com.hockeystone22.model.Results
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Contants.END_POİNT)
    suspend fun getAllHockeyPlayerService():Response<Player>
}