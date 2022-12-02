package com.jh.data.repository.source

import com.jh.data.api.UserService
import com.jh.domain.model.User
import com.jh.domain.repository.source.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: UserService
) : RemoteDataSource {

    override suspend fun getUsers(): List<User> {
        return service.getUsers()
    }
}