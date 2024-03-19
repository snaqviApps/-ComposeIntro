package edu.coding.randomuserApp.randomuser.data.remote.response



import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Id(
    @SerializedName("name") val name: String? = "",
    @SerializedName("value") val value: @RawValue Any? = null
) : Parcelable