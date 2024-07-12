package org.example.urlshortner.domain.service

import org.example.urlshortner.db.repositories.UrlRepository
import org.example.urlshortner.domain.model.Url
import org.example.urlshortner.domain.model.UrlIdentifier
import org.example.urlshortner.domain.model.toUrl
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service


@Service
class UrlService(
    private val urlRepository: UrlRepository
) {

    fun createIdentifier(url: Url) = (url.url.hashCode() * url.url.length.hashCode()).also { hashedUrl ->
        urlRepository.addUrl(hashedUrl, url.url)
    }

    fun getFullUrl(urlIdentifier: UrlIdentifier) = urlRepository.findByIdentifier(urlIdentifier.identifier)?.toUrl()

    fun deleteUrl(urlIdentifier: UrlIdentifier): Boolean = urlRepository.deleteUrl(urlIdentifier.identifier)
}