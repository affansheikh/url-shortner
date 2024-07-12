package org.example.urlshortner.adapters.incoming

import org.example.urlshortner.domain.model.toUrlIdentifier
import org.example.urlshortner.domain.ports.GetUrl
import org.example.urlshortner.domain.service.UrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class GetUrl(
    private val urlService: UrlService
) : GetUrl {

    @GetMapping("urls/{urlIdentifier}")
    override fun getFullUrl(
        @PathVariable urlIdentifier: String
    ): ResponseEntity<ResponseUrl> {
        val identifier = urlIdentifier.toUrlIdentifier()
        val fetchedUrl = urlService.getFullUrl(identifier)
        fetchedUrl?.let {
            return ResponseEntity.ok(ResponseUrl(fetchedUrl.url))
        } ?: return ResponseEntity.notFound().build()
    }

}