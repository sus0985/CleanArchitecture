package com.jh.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    @SerialName("zipcode")
    val zipCode: String
)