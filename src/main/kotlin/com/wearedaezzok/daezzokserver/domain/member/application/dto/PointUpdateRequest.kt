package com.wearedaezzok.daezzokserver.domain.member.application.dto

data class PointUpdateRequest(
    val memberId: Long,
    val point: Int,
)
