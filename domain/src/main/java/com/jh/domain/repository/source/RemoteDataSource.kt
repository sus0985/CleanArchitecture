package com.jh.domain.repository.source

import com.jh.domain.model.User

interface RemoteDataSource {

    suspend fun getUsers(): List<User>

}