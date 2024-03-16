package edu.coding.randomuserApp.randomuser.data.remote.response


import com.google.gson.annotations.SerializedName

data class Street(
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: Int
)