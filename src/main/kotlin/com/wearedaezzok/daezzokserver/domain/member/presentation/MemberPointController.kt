package com.wearedaezzok.daezzokserver.domain.member.presentation

import com.wearedaezzok.daezzokserver.domain.member.application.MemberPointService
import com.wearedaezzok.daezzokserver.domain.member.application.dto.PointUpdateRequest
import com.wearedaezzok.daezzokserver.domain.member.application.dto.PointUpdateResponse
import com.wearedaezzok.daezzokserver.global.common.response.SuccessResponse
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/members/point")
class MemberPointController(
    private val memberPointService: MemberPointService
) {

    @PatchMapping
    fun updatePoints(@RequestBody request: List<PointUpdateRequest>) : SuccessResponse<List<PointUpdateResponse>> {
        return SuccessResponse.create("포인트 수정 성공", memberPointService.updatePoint(request))
    }
}
