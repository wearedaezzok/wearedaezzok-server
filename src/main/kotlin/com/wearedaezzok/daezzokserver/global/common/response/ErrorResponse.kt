package com.wearedaezzok.daezzokserver.global.common.response

class ErrorResponse(
    val code: String,
    val message: String,
) {
    companion object {
        fun create(
            code: String,
            message: String,
        ): ErrorResponse {
            return ErrorResponse(code, message)
        }
    }
}
