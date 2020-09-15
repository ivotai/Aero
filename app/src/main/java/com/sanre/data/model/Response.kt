package com.sanre.data.model

import com.sanre.app.toast

open class Response<T>(
    val message: String?,
    val success: Boolean,
    val data: T
) {
    val failed: Boolean
        get() {
            val failed = !success
            if (failed) message?.toast()
            return failed
        }
}