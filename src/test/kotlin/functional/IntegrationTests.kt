package functional

import functional.users.User
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.kotlin.test.test

class IntegrationTests {

    private val application = Application(8181)
    private val client = WebClient.create("http://localhost:8181")

    @BeforeAll
    fun beforeAll() {
        application.start()
    }

    @Test
    fun `Find all users on via users endpoint`() {
        client.get().uri("/api/users")
            .accept(APPLICATION_JSON)
            .retrieve()
            .bodyToFlux<User>()
            .test()
            .expectNextMatches { it.firstname == "carmine" && it.lastname == "d" }
            .expectNextMatches { it.firstname == "eliana" && it.lastname == "g" }
            .expectNextMatches { it.firstname == "laura" && it.lastname == "h" }
            .verifyComplete()
    }

    @AfterAll
    fun afterAll() {
        application.stop()
    }
}