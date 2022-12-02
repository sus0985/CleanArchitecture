package com.jh.architecture

import androidx.lifecycle.ViewModel
import com.jh.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    val getUsersResult = getUsersUseCase()

}