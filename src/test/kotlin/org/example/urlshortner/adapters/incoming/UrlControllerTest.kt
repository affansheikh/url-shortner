package org.example.urlshortner.adapters.incoming

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.urlshortner.domain.service.UrlService
import org.example.urlshortner.testCreateIdentifierRequest
import org.example.urlshortner.testIdentifier
import org.example.urlshortner.testUrl
import org.example.urlshortner.testUrlIdentifier
import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class UrlControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    lateinit var urlService: UrlService

    @Test
    fun `returns 200 with url on successful fetch`() {
        whenever(urlService.getFullUrl(testUrlIdentifier)).thenReturn(testUrl)

        mvc.perform(MockMvcRequestBuilders.get("/urls/${testUrlIdentifier.identifier}"))
            .andExpect(
                status().`is`(HttpStatus.OK.value())
            )
            .andExpect(
                content().contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(
                content().json(responseUrl)
            )
    }

    @Test
    fun `returns 404 when url does not exist on fetch`() {
        whenever(urlService.getFullUrl(testUrlIdentifier)).thenReturn(null)

        mvc.perform(MockMvcRequestBuilders.get("/urls/${testUrlIdentifier.identifier}"))
            .andExpect(
                status().`is`(HttpStatus.NOT_FOUND.value())
            )
    }

    @Test
    fun `returns 200 with identifier on successful create`() {
        whenever(urlService.createIdentifier(testUrl)).thenReturn(testIdentifier)

        mvc.perform(MockMvcRequestBuilders
            .post("/urls/identifier")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(testCreateIdentifierRequest))
        )
            .andExpect(
                status().`is`(HttpStatus.OK.value())
            )
            .andExpect(
                content().json(responseIdentifier)
            )
    }

    @Test
    fun `returns 500 on failed create`() {
        whenever(urlService.createIdentifier(testUrl)).thenThrow(IllegalArgumentException())

        mvc.perform(MockMvcRequestBuilders
            .post("/urls/identifier")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(testCreateIdentifierRequest))
        )
            .andExpect(
                status().`is`(HttpStatus.INTERNAL_SERVER_ERROR.value())
            )
    }


    private val responseUrl = """
        {
            url: "https://www.test.com"
        }
    """.trimIndent()

    private val responseIdentifier = """
        {
            identifier: 56
        }
    """.trimIndent()
}