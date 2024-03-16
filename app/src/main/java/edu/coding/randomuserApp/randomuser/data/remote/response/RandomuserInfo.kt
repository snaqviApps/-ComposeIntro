package edu.coding.randomuserApp.randomuser.data.remote.response

import com.google.gson.annotations.SerializedName

data class RandomuserInfo(
    @SerializedName("info") val info: Info,
    @SerializedName("results") val results: List<RandomuserDTO>
)