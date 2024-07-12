package org.example.urlshortner.domain.ports

import org.example.urlshortner.adapters.incoming.ResponseUrl
import org.springframework.http.ResponseEntity

interface GetUrl {
    fun getFullUrl(urlIdentifier: String): ResponseEntity<ResponseUrl>
}