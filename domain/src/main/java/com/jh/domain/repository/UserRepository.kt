package com.jh.domain.repository

import com.jh.domain.model.Response
import com.jh.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<Response<List<User>>>

}