package com.wearedaezzok.daezzokserver.domain.member.domain

import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<Member, Long>
