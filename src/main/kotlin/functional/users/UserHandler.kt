package functional.users

import functional.common.validate
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

class UserHandler(val userService: UserService) {

    fun findAll(req: ServerRequest): Mono<ServerResponse> = validate
        .request(req) {
            ok().body(userService.findAll())
        }

    fun create(req: ServerRequest) = validate
        .request(req)
        .withBody(User::class.java) { user ->
            ok().body(userService.create(user))
        }
}