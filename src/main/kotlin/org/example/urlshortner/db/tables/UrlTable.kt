package org.example.urlshortner.db.tables

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.jodatime.datetime

object UrlTable : LongIdTable("urls") {
    val urlIdentifier = integer("url_identifier")
    val url = varchar("url", 255)
    val createdAt = datetime("created_at")
}