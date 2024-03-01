package edu.coding.composeintro.randomuser.data.local.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface RandomuserDao {

    @Upsert
    suspend fun upsertRandomuser(randomuserDTO: RandomuserEntity)

    @Query("Select * From RandomuserEntity where id =  :ids")
    suspend fun getRandomuserById(ids: Int) : RandomuserEntity
}