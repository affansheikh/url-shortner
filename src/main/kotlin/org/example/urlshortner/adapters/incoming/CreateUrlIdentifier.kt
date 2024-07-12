package org.example.urlshortner.adapters.incoming

import org.example.urlshortner.domain.ports.CreateUrlIdentifier
import org.example.urlshortner.domain.service.UrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class CreateUrlIdentifier(
    private val urlService: UrlService,
) : CreateUrlIdentifier {

    @PostMapping("urls/identifier")
    override fun createIdentifier(
        @RequestBody createIdentifierRequest: CreateIdentifierRequest
    ): ResponseEntity<ResponseUrlIdentifier> {
        val url = createIdentifierRequest.url
        try {
            val urlIdentifier = urlService.createIdentifier(url).toResponseUrlIdentifier()
            return ResponseEntity.ok(urlIdentifier)

        } catch (ex: Exception) {
            return ResponseEntity.internalServerError().build()
        }
    }
}