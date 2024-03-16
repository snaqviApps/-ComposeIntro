package edu.coding.randomuserApp.randomuser.data.local.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import edu.coding.randomuserApp.randomuser.data.remote.response.Name

@Dao
interface RandomuserDao {

    @Upsert
    suspend fun upsertRandomuser(randomuserEntity: RandomuserEntity)

    @Query("Select * From RandomuserEntity where id =  :ids")
    suspend fun getRandomuserById(ids: Int) : RandomuserEntity?

    @Query("Select * From RandomuserEntity where name =  :name")
    suspend fun getRandomuserByName(name: Name) : List<RandomuserEntity>

    @Query("Select COUNT(*) From RandomuserEntity")
    suspend fun getRowsCount() : Int
}