package edu.coding.randomuserApp.randomuser.data.remote.response


import com.google.gson.annotations.SerializedName

data class Registered(
    @SerializedName("age") val age: Int,
    @SerializedName("date") val date: String
)