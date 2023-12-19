package com.wearedaezzok.daezzokserver

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class KotestSampleTest : ShouldSpec({
    should("1+1 is equal to 2") {
        1 + 1 shouldBe 2
    }
})
