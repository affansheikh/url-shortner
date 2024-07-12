package org.example.urlshortner.domain.model

@JvmInline
value class Url(val url: String)

@JvmInline
value class UrlIdentifier(val identifier: Int)


fun String.toUrl() = Url(this)