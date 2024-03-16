package edu.coding.randomuserApp.randomuser.data.mapper

import edu.coding.randomuserApp.randomuser.data.local.db.RandomuserEntity
import edu.coding.randomuserApp.randomuser.data.remote.response.Coordinates
import edu.coding.randomuserApp.randomuser.data.remote.response.Dob
import edu.coding.randomuserApp.randomuser.data.remote.response.Id
import edu.coding.randomuserApp.randomuser.data.remote.response.Location
import edu.coding.randomuserApp.randomuser.data.remote.response.Login
import edu.coding.randomuserApp.randomuser.data.remote.response.Name
import edu.coding.randomuserApp.randomuser.data.remote.response.Picture
import edu.coding.randomuserApp.randomuser.data.remote.response.RandomuserDTO
import edu.coding.randomuserApp.randomuser.data.remote.response.Registered
import edu.coding.randomuserApp.randomuser.data.remote.response.Street
import edu.coding.randomuserApp.randomuser.data.remote.response.Timezone
import edu.coding.randomuserApp.randomuser.domain.model.Randomuser

/**
 * An Extension function to the RandomuserEntity class
 * that maps to
 */


fun RandomuserDTO.toRandomuserEntity(
    ids: Int
): RandomuserEntity {
    return RandomuserEntity(
        cell = cell ?: "",
        dob = dob ?: Dob(-1, ""),
        email = email ?: "",
        gender = gender ?: "",
        id = id ?: Id(""),
        location = location ?: Location("",
            Coordinates("", ""),
            "", -1, "",
            Street("", -1),
            Timezone("", "")
        ),
        login = login ?: Login("", "", "", "", "", "", ""),
        name = name ?: Name("", "", ""),
        nat = nat ?: "",
        phone = phone ?: "",
        picture = picture ?: Picture("", "", ""),
        registered = registered ?: Registered(-1, ""),

        ids = -1
    )
}

/**
 * An Extension function to the RandomuserEntity class
 * that maps Entity to Data-Object it is handling (Randomuser)
 */
fun RandomuserEntity.toRandomuser(
    ids: Int
): Randomuser {
    return Randomuser(
        cell = cell,
        dob = Dob(
            age = dob.age,
            date = dob.date
        ),
        email = email,
        gender = gender,
        location = Location(
            city = location.city,
            coordinates = location.coordinates,
            country = location.country,
            postcode = location.postcode,
            state = location.state,
            street = location.street,
            timezone = location.timezone
        ),
        login = Login(
            md5 = login.md5,
            password = login.password,
            salt = login.salt,
            sha1 = login.sha1,
            sha256 = login.sha256,
            username = login.username,
            uuid = login.uuid
        ),
        name = Name(
            first = name.first,
            last = name.last,
            title = name.title
        ),
        nat = nat,
        phone = phone,
        picture = Picture(
            large = picture.large,
            medium = picture.medium,
            thumbnail = picture.thumbnail
        ),
        registered = Registered(age = registered.age, date = registered.date),
        id = Id(name = this.id.name, value = this.id.value)
    )
}