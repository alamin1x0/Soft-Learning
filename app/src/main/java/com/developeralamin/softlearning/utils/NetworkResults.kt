package com.developeralamin.softlearning.utils

sealed class NetworkResults<T>(
    val data : T? = null,
    val message : String? = null
) {
    class SUCCESS<T>(data: T?) : NetworkResults<T>(data)
    class ERROR<T>(data: T? = null, message: String?) : NetworkResults<T>(data)
    class LOADING<T> : NetworkResults<T>()
}