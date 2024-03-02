package edu.coding.composeintro.randomuser.util

import edu.coding.composeintro.randomuser.domain.model.Randomuser

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data, message)
    class Loading<T>(val isLoading: Boolean): Resource<T>(null)
}