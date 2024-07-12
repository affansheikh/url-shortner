package org.example.urlshortner.adapters.incoming

data class ResponseUrlIdentifier(
    val identifier: Int
)

data class ResponseUrl(
    val url: String
)

fun Int.toResponseUrlIdentifier() = ResponseUrlIdentifier(this)
