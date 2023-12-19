package com.wearedaezzok.daezzokserver.domain.member.application

import com.wearedaezzok.daezzokserver.domain.member.application.dto.MemberCreateRequest
import com.wearedaezzok.daezzokserver.domain.member.application.dto.MemberCreateResponse
import com.wearedaezzok.daezzokserver.domain.member.domain.Member
import com.wearedaezzok.daezzokserver.domain.member.domain.MemberJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class MemberService(
    private val memberJpaRepository: MemberJpaRepository
) {
    fun createMembers(request: List<MemberCreateRequest>) : List<MemberCreateResponse>{
        val response = request.stream()
            .map {
                val member =  memberJpaRepository.save(Member(name = it.name))
                MemberCreateResponse.of(member)
            }.toList()
        return response
    }
}
