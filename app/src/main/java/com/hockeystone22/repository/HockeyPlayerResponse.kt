package com.hockeystone22.repository

import android.util.Log
import com.hockeystone22.data.PlayerDatabase
import com.hockeystone22.model.LocalFootbalItem
import com.hockeystone22.model.Player
import com.hockeystone22.model.Results
import com.hockeystone22.model.Topgoal
import com.hockeystone22.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class HockeyPlayerResponse @Inject constructor (private val api:ApiService, private val db:PlayerDatabase) {

    private val database=db.playerDao()

    suspend fun GetAllHockeyPlayer(): Response<Player> {
        val response =api.getAllHockeyPlayerService()
        if (response.isSuccessful){
            Log.d("testApp","Success to connected to HockeyPlayer response")
            Log.d("testApp",response.code().toString())
        }
        else{
            Log.d("testApp","Failed to connected to HockeyPlayer response")
            Log.d("testApp",response.code().toString())
        }
        return response
    }
    suspend fun insertPlayer(localFootbalItem: MutableList<LocalFootbalItem>){
        database.insert(localFootbalItem)
    }
    val getPlayerSaved=database.getSavedPlayer()
}