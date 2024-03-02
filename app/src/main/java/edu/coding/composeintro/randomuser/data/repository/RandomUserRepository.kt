package edu.coding.composeintro.randomuser.data.repository

import edu.coding.composeintro.randomuser.data.local.db.RandomuserDatabase
import edu.coding.composeintro.randomuser.data.local.db.RandomuserEntity
import edu.coding.composeintro.randomuser.data.mapper.toRandomuser
import edu.coding.composeintro.randomuser.data.remote.RandomuserApi
import edu.coding.composeintro.randomuser.data.remote.response.Name
import edu.coding.composeintro.randomuser.domain.model.Randomuser
import edu.coding.composeintro.randomuser.domain.repository.IRandomUserRepository
import edu.coding.composeintro.randomuser.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RandomUserRepository(
    private val randomuserApi: RandomuserApi,
    private val randomuserDatabase: RandomuserDatabase
) : IRandomUserRepository {
    override suspend fun getRandomuser(
        forceFetchRemoteUser: Boolean,
        ids: Int,
        name: Name
    ): Flow<Resource<List<Randomuser>>> {
        return flow {
            emit(Resource.Loading(true))

            /** if
             * 1. db isNotEmpty() == true && forcedFetch != true
             * Load from local DB
             * else
             * fetch from remote
             *
             * 'isTotalLessThan10' checks if the rows count is equal to 10
             *
             */
//            val localRandomuser: RandomuserEntity? = randomuserDatabase.randomuserDao.getRandomuserById(ids)

            val localRandomuserList: List<RandomuserEntity> = randomuserDatabase.randomuserDao.getRandomuserByName(name)
            val isTotalLessThan10 = randomuserDatabase.randomuserDao.getRowsCount()
            val isLoadingFromLocal = (localRandomuserList.isNotEmpty() && !forceFetchRemoteUser) && (isTotalLessThan10 >= 10)

            /**
             * need to be validated if 10-records are needed to furnish the UI
             */
            if (isLoadingFromLocal) {
                emit(Resource.Success(
                    data = localRandomuserList.map {
                        it.toRandomuser(ids)
                    }
                ))
                emit(Resource.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun getRandomuser(ids: Int): Flow<Resource<Randomuser>> {
        return flow {
            emit(Resource.Loading(true))
            val randomuserEntity = randomuserDatabase.randomuserDao.getRandomuserById(ids)
            randomuserEntity?.let {
                emit(
                    Resource.Success(it.toRandomuser(ids))
                )
                emit(Resource.Loading(false))
                return@flow
            }
            emit(Resource.Error("no random-user data is available with this ID!"))
            emit(Resource.Loading(false))
        }

    }
}