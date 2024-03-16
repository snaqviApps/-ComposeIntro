package edu.coding.randomuserApp.randomuser.data.remote.response


import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("name") val name: String? = "",
    @SerializedName("value") val value: Any? = null
)