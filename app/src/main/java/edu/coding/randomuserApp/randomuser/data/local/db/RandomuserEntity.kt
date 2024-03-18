package edu.coding.randomuserApp.randomuser.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import edu.coding.randomuserApp.randomuser.data.remote.response.Dob
import edu.coding.randomuserApp.randomuser.data.remote.response.Id
import edu.coding.randomuserApp.randomuser.data.remote.response.Location
import edu.coding.randomuserApp.randomuser.data.remote.response.Login
import edu.coding.randomuserApp.randomuser.data.remote.response.Name
import edu.coding.randomuserApp.randomuser.data.remote.response.Picture
import edu.coding.randomuserApp.randomuser.data.remote.response.Registered
import com.google.gson.annotations.SerializedName

@Entity
data class RandomuserEntity(
    @SerializedName("cell") val cell: String,
    @SerializedName("dob") val dob: Dob,
    @SerializedName("email") val email: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("location") val location: Location,
    @SerializedName("login") val login: Login,
    @SerializedName("name") val name: Name,
    @SerializedName("nat") val nat: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("picture") val picture: Picture,
    @SerializedName("registered") val registered: Registered,
    @SerializedName("id") val id: Id,

    @PrimaryKey(autoGenerate = true)
    val ids: Int?
)