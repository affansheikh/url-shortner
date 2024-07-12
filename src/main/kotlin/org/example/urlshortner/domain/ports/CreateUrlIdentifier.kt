package org.example.urlshortner.domain.ports

import org.example.urlshortner.domain.model.UrlIdentifier
import org.example.urlshortner.domain.model.Url

interface CreateUrlIdentifier {
    fun createIdentifier(url: Url): UrlIdentifier
}