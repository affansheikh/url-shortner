package org.example.urlshortner.domain.service

import org.example.urlshortner.domain.model.calculateHash
import org.example.urlshortner.domain.model.toUrl
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


class UrlServiceTest {

    @Test
    fun `different urls generate different hash`() {
        val googleUrl = "https://www.google.com".toUrl()
        val facebookUrl = "https://www.facebook.com".toUrl()

        val googleHash = googleUrl.calculateHash()
        val facebookHash = facebookUrl.calculateHash()

        assertNotEquals(googleHash, facebookHash)
    }

    @Test
    fun `same url generates same hash`() {
        val googleUrl = "https://www.google.com".toUrl()

        val googleHash1 = googleUrl.calculateHash()
        val googleHash2 = googleUrl.calculateHash()

        assertEquals(googleHash1, googleHash2)
    }
}