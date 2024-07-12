package org.example.urlshortner.db.repositories

import org.springframework.stereotype.Repository

@Repository
interface UrlRepository{
    fun addUrl(hashedUrl: Int, url: String): Boolean
    fun findByIdentifier(identifier: Int): String?
    fun deleteUrl(identifier: Int): Boolean
}

class UrlRepositoryImpl(
): UrlRepository{
    override fun addUrl(hashedUrl: Int, url: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun findByIdentifier(identifier: Int): String? {
        TODO("Not yet implemented")
    }

    override fun deleteUrl(identifier: Int): Boolean {
        TODO("Not yet implemented")
    }
}