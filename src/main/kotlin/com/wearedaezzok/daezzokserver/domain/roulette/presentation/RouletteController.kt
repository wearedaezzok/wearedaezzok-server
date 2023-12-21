package com.wearedaezzok.daezzokserver.domain.roulette.presentation

import com.wearedaezzok.daezzokserver.domain.roulette.Roulette
import com.wearedaezzok.daezzokserver.domain.roulette.RouletteJpaRepository
import com.wearedaezzok.daezzokserver.global.common.response.SuccessResponse
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

@RestController
@RequestMapping("api/v1/roulette")
@Transactional(readOnly = true)
class RouletteController(
    private val rouletteJpaRepository: RouletteJpaRepository,
) {
    @GetMapping("/result")
    fun getRouletteQuestion(): SuccessResponse<RouletteResponse> {
        val rouletteLength = rouletteJpaRepository.count()
        val randomId = (0..rouletteLength.toInt()).random().toLong()
        val response =
            rouletteJpaRepository.findById(randomId)
                .orElseThrow { throw RuntimeException("존재하지 않는 룰렛 내용입니다.") }
        return SuccessResponse.create("룰렛 결과 조회 성공", RouletteResponse.of(response))
    }

    data class RouletteResponse(
        val id: Long?,
        val content: String,
    ) {
        companion object {
            fun of(roulette: Roulette): RouletteResponse {
                return RouletteResponse(
                    id = roulette.id,
                    content = roulette.content,
                )
            }
        }
    }
}
