package edu.coding.randomuserApp.randomuser.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import edu.coding.randomuserApp.randomuser.data.local.db.RandomuserDatabase
import edu.coding.randomuserApp.randomuser.data.local.db.RandomuserEntity
import edu.coding.randomuserApp.randomuser.data.mapper.toRandomuser
import edu.coding.randomuserApp.randomuser.data.mapper.toRandomuserEntity
import edu.coding.randomuserApp.randomuser.data.remote.RandomuserApi
import edu.coding.randomuserApp.randomuser.data.remote.response.Name
import edu.coding.randomuserApp.randomuser.domain.model.Randomuser
import edu.coding.randomuserApp.randomuser.domain.repository.IRandomUserRepository
import edu.coding.randomuserApp.randomuser.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class RandomUserRepository(
    private val randomuserApi: RandomuserApi,
    private val randomuserDatabase: RandomuserDatabase
) : IRandomUserRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getRandomuser(
        forcedFetchRemoteUser: Boolean,
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
             * 'isTotalLessThan10' checks if the rows count is equal to 10
             *
             */
//            val localRandomuser: RandomuserEntity? = randomuserDatabase.randomuserDao.getRandomuserById(ids)

            val localRandomuserList: List<RandomuserEntity> = randomuserDatabase.randomuserDao.getRandomuserByName(name)
            val isTotalLessThan10 = randomuserDatabase.randomuserDao.getRowsCount()
            val isLoadingFromLocal = (localRandomuserList.isNotEmpty() && !forcedFetchRemoteUser) && (isTotalLessThan10 >= 10)

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

            /**
             * if "isLoadingFromLocal" results in 'false'
             * then fetch data from api-call,
             * still save it to db first as SST (single source of truth)
             */
            val randomuserFromApi = try {
                randomuserApi.getRandomuser()
            } catch (e: IOException){
               e.printStackTrace()
               emit(Resource.Error(message = "Error fetching user-data"))
               return@flow
            }
            catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error fetching user-data"))
                return@flow
            }

            val randomuserEntity : RandomuserEntity = randomuserFromApi
                    .toRandomuserEntity(ids)
                    .apply {
                        randomuserDatabase.randomuserDao.upsertRandomuser(this)
                    }
            emit(Resource.Success(listOf(randomuserEntity.toRandomuser(ids))))
            emit(Resource.Loading(false))
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