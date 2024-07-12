package org.example.urlshortner.adapters.incoming

import org.example.urlshortner.domain.model.Url

data class CreateIdentifierRequest(
    val url: Url
)