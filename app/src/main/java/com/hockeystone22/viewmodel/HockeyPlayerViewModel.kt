package com.hockeystone22.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hockeystone22.model.LocalFootbalItem
import com.hockeystone22.model.Results

import com.hockeystone22.model.Topgoal
import com.hockeystone22.repository.HockeyPlayerResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HockeyPlayerViewModel @Inject constructor(private val repository:HockeyPlayerResponse) :ViewModel(){

   private  val _gethockeyplayerLivedata=MutableLiveData<List<Topgoal>>()

     val gethockeylist:LiveData<List<Topgoal>> =_gethockeyplayerLivedata


    fun getallplayerviewModel()=
        viewModelScope.launch {
            val response =repository.GetAllHockeyPlayer().let {
                response ->
                if (response.isSuccessful){
                    _gethockeyplayerLivedata.postValue(response.body()?.let { it.results.topgoals})
                }else{
                    Log.d("testApp",response.message().toString())
                }
            }
        }
    fun insertPlayer(localFootbalItem: MutableList<LocalFootbalItem>)=viewModelScope.launch {
        repository.insertPlayer(localFootbalItem)
    }
    fun getSavedPlayer()=repository.getPlayerSaved
}