package edu.coding.randomuserApp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.coding.randomuserApp.randomuser.data.repository.RandomUserRepositoryImpl
import edu.coding.randomuserApp.randomuser.domain.repository.RandomUserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsRandomuserRepository(
        randomUserRepository: RandomUserRepositoryImpl
    ): RandomUserRepository
}