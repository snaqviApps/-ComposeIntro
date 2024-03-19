package edu.coding.randomuserApp.randomuser.domain.repository

import edu.coding.randomuserApp.randomuser.data.remote.response.Name
import edu.coding.randomuserApp.randomuser.domain.model.Randomuser
import edu.coding.randomuserApp.randomuser.util.Resource
import kotlinx.coroutines.flow.Flow


interface RandomUserRepository {

    suspend fun getTenRandomusers(
//        id: Int = -1,
        name: Name? = null
//    ) : Flow<Resource<List<Randomuser>>>
    ) : Flow<Resource<Randomuser>>

    suspend fun getRandomuser(ids: Int) : Flow<Resource<Randomuser>>
}