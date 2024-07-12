package org.example.urlshortner.domain.ports

import org.example.urlshortner.domain.model.ShortUrl
import org.example.urlshortner.domain.model.Url

interface GetUrl {
    fun getFullUrl(shortUrl: ShortUrl): Url
}