package com.hockeystone22.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hockeystone22.model.LocalFootbalItem

@Database(entities = [LocalFootbalItem::class], version = 2)
@TypeConverters(PlayerTypeConverter::class)
abstract class PlayerDatabase: RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}