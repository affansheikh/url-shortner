package org.example.urlshortner.domain.service

import org.example.urlshortner.domain.model.ShortUrl
import org.example.urlshortner.domain.model.Url
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service


@Service
class UrlService(
    private val urlRepository: UrlRepository
) {

    fun shortenUrl(url: Url) = (url.value.hashCode() * url.value.length.hashCode()).also { hashedUrl ->
        urlRepository.addUrl(hashedUrl, url.value)
    }

    fun getFullUrl(shortUrl: ShortUrl) = urlRepository.findByShortUrl(shortUrl)
}