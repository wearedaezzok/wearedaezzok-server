package com.wearedaezzok.daezzokserver.domain.member.application.dto

import com.wearedaezzok.daezzokserver.domain.member.domain.Member

class PointUpdateResponse(
    val id: Long?,
    val name: String,
    val point: Int,
) {
    companion object {
        fun of(member: Member): PointUpdateResponse {
            return PointUpdateResponse(
                id = member.id,
                name = member.name,
                point = member.point,
            )
        }
    }
}
