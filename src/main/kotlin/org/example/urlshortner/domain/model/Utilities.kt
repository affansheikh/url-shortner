package org.example.urlshortner.domain.model

@JvmInline
value class Url(val url: String)

@JvmInline
value class UrlIdentifier(val identifier: Int)


fun String.toUrl() = Url(this)
fun Int.toUrlIdentifier() = UrlIdentifier(this)
fun String.toUrlIdentifier() = UrlIdentifier(this.toInt())