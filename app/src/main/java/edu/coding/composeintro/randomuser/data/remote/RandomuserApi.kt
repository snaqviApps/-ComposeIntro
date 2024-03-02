package edu.coding.composeintro.randomuser.data.remote

import retrofit2.http.GET

interface RandomuserApi {

    @GET("api/")
    suspend fun getRandomuser()
}