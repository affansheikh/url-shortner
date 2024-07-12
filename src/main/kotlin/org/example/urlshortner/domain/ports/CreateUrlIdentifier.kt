package org.example.urlshortner.domain.ports

import org.example.urlshortner.adapters.incoming.CreateIdentifierRequest
import org.example.urlshortner.adapters.incoming.ResponseUrlIdentifier
import org.springframework.http.ResponseEntity

interface CreateUrlIdentifier {
    fun createIdentifier(createIdentifierRequest: CreateIdentifierRequest): ResponseEntity<ResponseUrlIdentifier>
}