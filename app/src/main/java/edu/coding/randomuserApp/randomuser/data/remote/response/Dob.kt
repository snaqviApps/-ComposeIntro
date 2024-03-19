package edu.coding.randomuserApp.randomuser.data.remote.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dob(
    @SerializedName("age") val age: Int,
    @SerializedName("date") val date: String
) : Parcelable