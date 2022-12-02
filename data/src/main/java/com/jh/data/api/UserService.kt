package com.jh.data.api

import com.jh.domain.model.User
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getUsers(): List<User>
}