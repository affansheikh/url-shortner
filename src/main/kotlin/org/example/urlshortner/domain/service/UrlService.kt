package org.example.urlshortner.domain.service

import org.example.urlshortner.db.repositories.UrlRepository
import org.example.urlshortner.domain.model.Url
import org.example.urlshortner.domain.model.UrlIdentifier
import org.example.urlshortner.domain.model.calculateHash
import org.example.urlshortner.domain.model.toUrl
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service


@Service
class UrlService(
    private val urlRepository: UrlRepository
) {

    fun createIdentifier(url: Url) = url.calculateHash().also { hashedUrl ->
        urlRepository.addUrl(hashedUrl, url.url)
    }

    @Cacheable(cacheNames = ["urls"], key = "#urlIdentifier", cacheManager = "urlCacheManager")
    fun getFullUrl(urlIdentifier: UrlIdentifier) = urlRepository.findByIdentifier(urlIdentifier.identifier)?.toUrl()

    @CacheEvict(cacheNames = ["urls"], key = "#urlIdentifier", cacheManager = "urlCacheManager")
    fun deleteUrl(urlIdentifier: UrlIdentifier): Boolean = urlRepository.deleteUrl(urlIdentifier.identifier)

}