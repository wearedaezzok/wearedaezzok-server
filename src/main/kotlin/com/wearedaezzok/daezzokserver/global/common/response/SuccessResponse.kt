package com.wearedaezzok.daezzokserver.global.common.response

import com.fasterxml.jackson.annotation.JsonInclude

class SuccessResponse<T>(
    val message: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var data: T?
) {
    companion object {

        fun <T> create(message: String, data: T): SuccessResponse<T> {
            return SuccessResponse(message, data)
        }
        fun <T> create(message: String): SuccessResponse<T> {
            return SuccessResponse(message, null)
        }
    }
}
