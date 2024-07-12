package org.example.urlshortner

import org.example.urlshortner.adapters.incoming.CreateIdentifierRequest
import org.example.urlshortner.domain.model.Url
import org.example.urlshortner.domain.model.UrlIdentifier

val testUrlIdentifier = UrlIdentifier(34)
val testUrl = Url("https://www.test.com")
val testIdentifier = 56
val testCreateIdentifierRequest = CreateIdentifierRequest(testUrl)