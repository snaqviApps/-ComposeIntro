package edu.coding.randomuserApp.randomuser.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RandomuserEntity::class], version = 1)
@TypeConverters(ConvertersCombined::class)
abstract class RandomuserDatabase : RoomDatabase() {
    abstract val randomuserDao : RandomuserDao
}