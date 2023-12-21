package com.wearedaezzok.daezzokserver.domain.member.presentation

import com.wearedaezzok.daezzokserver.domain.member.application.MemberService
import com.wearedaezzok.daezzokserver.domain.member.application.dto.MemberCreateRequest
import com.wearedaezzok.daezzokserver.domain.member.application.dto.MemberCreateResponse
import com.wearedaezzok.daezzokserver.global.common.response.SuccessMessage
import com.wearedaezzok.daezzokserver.global.common.response.SuccessResponse
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
    private val memberService: MemberService,
) {
    @Operation(description = "사용자 생성 API")
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun createMembers(
        @RequestBody request: List<MemberCreateRequest>,
    ): SuccessResponse<List<MemberCreateResponse>> {
        val response = memberService.createMembers(request)
        return SuccessResponse.create(SuccessMessage.SUCCESS_CREATE_MEMBERS.value, response)
    }
}
