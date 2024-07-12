package org.example.urlshortner

import org.example.urlshortner.db.repositories.UrlRepository
import org.example.urlshortner.db.repositories.UrlRepositoryImpl
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class, HibernateJpaAutoConfiguration::class] )
@EnableCaching
class UrlShortnerApplication

fun main(args: Array<String>) {
    runApplication<UrlShortnerApplication>(*args)
}

@Component
class BeanDeclaration {

    @Bean
    fun urlRepository(): UrlRepository = UrlRepositoryImpl()
}