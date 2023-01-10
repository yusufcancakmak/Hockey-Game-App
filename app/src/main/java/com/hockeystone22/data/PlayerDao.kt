package com.hockeystone22.data

import androidx.room.*
import com.hockeystone22.model.LocalFootbalItem
import kotlinx.coroutines.flow.Flow


    @Dao
    interface PlayerDao {


        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(localFootbalItem: MutableList<LocalFootbalItem>)

        @Query("SELECT * FROM playerinfo ")
        fun getSavedPlayer(): Flow<List<LocalFootbalItem>>





    }
