package edu.coding.randomuserApp.randomuser.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.coding.randomuserApp.randomuser.data.remote.response.Coordinates
import edu.coding.randomuserApp.randomuser.data.remote.response.Dob
import edu.coding.randomuserApp.randomuser.data.remote.response.Id
import edu.coding.randomuserApp.randomuser.data.remote.response.Location
import edu.coding.randomuserApp.randomuser.data.remote.response.Login
import edu.coding.randomuserApp.randomuser.data.remote.response.Name
import edu.coding.randomuserApp.randomuser.data.remote.response.Picture
import edu.coding.randomuserApp.randomuser.data.remote.response.Registered
import edu.coding.randomuserApp.randomuser.data.remote.response.Street
import edu.coding.randomuserApp.randomuser.data.remote.response.Timezone

class ConvertersCombined {

    /** DOB Handling */
    @TypeConverter
    fun dobToJson(dob: Dob)  = Gson().toJson(dob)

    @TypeConverter
    fun stringToDob(gsonValue : String) = Gson().fromJson(gsonValue, Dob::class.java)
    /** DOB Handling ENDS */

    /** Id Handling */
    @TypeConverter
    fun idToJson(id: Id)  = Gson().toJson(id)

    @TypeConverter
    fun stringToId(gsonValue : String) = Gson().fromJson(gsonValue, Id::class.java)
    /** Id Handling ENDS */

    /** Location Handling */
    @TypeConverter
    fun locationToJson(location: Location)  = Gson().toJson(location)

    @TypeConverter
    fun stringToLocation(gsonValue : String) = Gson().fromJson(gsonValue, Location::class.java)
    /** Location Handling ENDS */

    /** Timezone Handling */
    @TypeConverter
    fun timezoneToJson(timezone: Timezone)  = Gson().toJson(timezone)

    @TypeConverter
    fun stringToTimezone(gsonValue : String) = Gson().fromJson(gsonValue, Timezone::class.java)
    /** Timezone Handling ENDS */

    /** Coordinates Handling */
    @TypeConverter
    fun coordinatesToJson(coordinates: Coordinates)  = Gson().toJson(coordinates)

    @TypeConverter
    fun stringToCoordinates(gsonValue : String) = Gson().fromJson(gsonValue, Coordinates::class.java)
    /** Coordinates Handling ENDS */

    /** Street Handling */
    @TypeConverter
    fun streetToJson(street: Street)  = Gson().toJson(street)

    @TypeConverter
    fun stringToStreet(gsonValue : String) = Gson().fromJson(gsonValue, Street::class.java)
    /** Street Handling ENDS */

    /** Name Handling */
    @TypeConverter
    fun nameToJson(name: Name): String = Gson().toJson(name)

    @TypeConverter
    fun stringToName(gsonValue : String) = Gson().fromJson(gsonValue, Name::class.java)
    /** Name Handling ENDS */

    /** Picture Handling */
    @TypeConverter
    fun pictureToJson(picture: Picture)  = Gson().toJson(picture)

    @TypeConverter
    fun stringToPicture(gsonValue : String) = Gson().fromJson(gsonValue, Picture::class.java)
    /** Picture Handling ENDS */

    /** Registered Handling */
    @TypeConverter
    fun registeredToJson(registered: Registered)  = Gson().toJson(registered)

    @TypeConverter
    fun stringToRegistered(gsonValue : String) = Gson().fromJson(gsonValue, Registered::class.java)
    /** Registered Handling ENDS */


    /** Login Handling */
    @TypeConverter
    fun loginToJson(login: Login)  = Gson().toJson(login)

    @TypeConverter
    fun stringToLogin(gsonValue : String) = Gson().fromJson(gsonValue, Login::class.java)
    /** Login Handling ENDS */

}