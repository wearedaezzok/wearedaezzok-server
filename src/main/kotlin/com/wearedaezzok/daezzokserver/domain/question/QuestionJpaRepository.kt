package com.wearedaezzok.daezzokserver.domain.question

import org.springframework.data.jpa.repository.JpaRepository

interface QuestionJpaRepository : JpaRepository<Question, Long> {
}
