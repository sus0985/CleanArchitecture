package com.jh.data

import com.jh.data.api.UserService
import com.jh.data.repository.UserRepositoryImpl
import com.jh.data.repository.source.RemoteDataSourceImpl
import com.jh.domain.repository.UserRepository
import com.jh.domain.repository.source.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}