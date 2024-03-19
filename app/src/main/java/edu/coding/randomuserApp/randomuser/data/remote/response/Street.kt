package edu.coding.randomuserApp.randomuser.data.remote.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Street(
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: Int
) : Parcelable