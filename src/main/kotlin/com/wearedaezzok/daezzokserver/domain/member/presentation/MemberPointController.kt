package com.wearedaezzok.daezzokserver.domain.member.presentation

import com.wearedaezzok.daezzokserver.domain.member.application.MemberPointService
import com.wearedaezzok.daezzokserver.domain.member.application.dto.PointUpdateRequest
import com.wearedaezzok.daezzokserver.domain.member.application.dto.PointUpdateResponse
import com.wearedaezzok.daezzokserver.global.common.response.SuccessResponse
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members/point")
class MemberPointController(
    private val memberPointService: MemberPointService,
) {
    @Operation(description = "점수 업데이트 API")
    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    fun updatePoints(
        @RequestBody request: List<PointUpdateRequest>,
    ): SuccessResponse<List<PointUpdateResponse>> {
        return SuccessResponse.create("포인트 수정 성공", memberPointService.updatePoint(request))
    }
}
