package com.wearedaezzok.daezzokserver.domain.member.domain

import com.wearedaezzok.daezzokserver.domain.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<Member, Long> {
}
