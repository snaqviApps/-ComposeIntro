package edu.coding.composeintro.randomuser.domain.repository


interface IRandomUserRepository {

    suspend fun getRandomuser(
        forceFetch : Boolean
    )



}