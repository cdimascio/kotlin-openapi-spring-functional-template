package functional

import functional.models.User
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType.*
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.test.test
import java.time.LocalDate

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
				.expectNextMatches { it.firstName == "Foo" && it.lastName == "Foo" }
				.expectNextMatches { it.firstName == "Bar" && it.lastName == "Bar" }
				.expectNextMatches { it.firstName == "Baz" && it.lastName == "Baz" }
				.verifyComplete()
	}
	
	@AfterAll
	fun afterAll() {
		application.stop()
	}
}
