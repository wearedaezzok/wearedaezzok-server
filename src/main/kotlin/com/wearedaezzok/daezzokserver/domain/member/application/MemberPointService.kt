package com.wearedaezzok.daezzokserver.domain.member.application

import com.wearedaezzok.daezzokserver.domain.member.application.dto.PointUpdateRequest
import com.wearedaezzok.daezzokserver.domain.member.application.dto.PointUpdateResponse
import com.wearedaezzok.daezzokserver.domain.member.domain.Member
import com.wearedaezzok.daezzokserver.domain.member.domain.MemberJpaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
@Transactional(readOnly = true)
class MemberPointService(
    private val memberJpaRepository: MemberJpaRepository,
) {
    @Transactional
    fun updatePoint(request: List<PointUpdateRequest>): List<PointUpdateResponse> {
        return request.stream()
            .map {
                val member: Member =
                    memberJpaRepository.findById(it.memberId)
                        .orElseThrow { RuntimeException("존재하지 않는 사용자입니다.") }
                member.point += it.point
                PointUpdateResponse.of(member)
            }.toList()
    }
}
