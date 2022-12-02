package com.jh.data.repository

import com.jh.domain.model.Response
import com.jh.domain.model.User
import com.jh.domain.repository.UserRepository
import com.jh.domain.repository.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

class UserRepositoryImpl @Inject constructor(
    private val dataSource: RemoteDataSource
) : UserRepository {

    override fun getUsers(): Flow<Response<List<User>>> = api {
        dataSource.getUsers()
    }

    private fun <T> api(block: suspend () -> T): Flow<Response<T>> {
        return flow {
            emit(Response.Loading)
            runCatching {
                block()
            }.onSuccess { data ->
                emit(Response.Success(data))
            }.onFailure { t ->
                emit(Response.ApiError(t))
            }
        }
    }
}