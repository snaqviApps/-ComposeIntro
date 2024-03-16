package edu.coding.randomuserApp.randomuser.data.remote

import edu.coding.randomuserApp.randomuser.data.remote.response.RandomuserDTO
import retrofit2.http.GET

interface RandomuserApi {

    @GET("api/")
    suspend fun getRandomuser() : RandomuserDTO
}