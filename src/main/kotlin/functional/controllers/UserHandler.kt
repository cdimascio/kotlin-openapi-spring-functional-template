package functional.controllers

import functional.models.User
import functional.swagger.validators.Validate
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class UserHandler {

    private val users = Flux.just(
            User("carmine", "d"),
            User("eliana", "g"),
            User("laura", "h"))

    fun findAll(req: ServerRequest): Mono<ServerResponse> = Validate
            .request(req) { ok().body(users) }

    fun create(req: ServerRequest): Mono<ServerResponse> {
        return Validate
                .request(req)
                .withBody(User::class.java) { body -> ok().body(Mono.just(body)) }
    }
}
