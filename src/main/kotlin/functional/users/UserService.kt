package functional.users

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class UserService {

    private var users = mutableListOf(
        User("carmine", "d"),
        User("eliana", "g"),
        User("laura", "h")
    )

    fun findAll(): Flux<User> = Flux.fromIterable(users)

    fun create(user: User): Mono<User> {
        users.add(user)
        return Mono.just(user)
    }
}