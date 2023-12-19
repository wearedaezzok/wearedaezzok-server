package com.wearedaezzok.daezzokserver.domain.member.application.dto

import com.wearedaezzok.daezzokserver.domain.member.domain.Member

data class MemberCreateResponse(
    val id: Long?,
    val name: String,
    val point: Int
) {
    companion object {
        fun of(member: Member): MemberCreateResponse {
            return MemberCreateResponse(
                id = member.id,
                name = member.name,
                point = member.point
            )
        }
    }
}
