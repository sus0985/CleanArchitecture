package com.jh.domain.usecase

import com.jh.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke() = repository.getUsers()

}