package functional.controllers

import functional.internalServerError
import functional.models.User
import functional.validate
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class UserHandler {

    private var users = mutableListOf(
        User("carmine", "d"),
        User("eliana", "g"),
        User("laura", "h")
    )

    fun findAll(req: ServerRequest): Mono<ServerResponse> = validate
        .request(req) {
            val result = Flux.fromIterable(users)
            ok().body(result)
        }
        .onErrorResume { t -> internalServerError(t) }

    fun create(req: ServerRequest) = validate
        .request(req)
        .withBody(User::class.java) { user ->
            users.add(user)
            ok().body(Mono.just(user))
        }
        .onErrorResume { t -> internalServerError(t) }
}
