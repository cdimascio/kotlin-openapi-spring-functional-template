package functional.common

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.status
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

data class Error(val code: Int, val messages: List<String>)

fun badRequest(t: Throwable) = error(HttpStatus.BAD_REQUEST, t)
fun badRequest(message: String) = error(HttpStatus.BAD_REQUEST, message)

fun methodNotAllowed(t: Throwable) = error(HttpStatus.METHOD_NOT_ALLOWED, t)
fun methodNotAllowed(message: String) = error(HttpStatus.METHOD_NOT_ALLOWED, message)

fun internalServerError(message: String) = error(HttpStatus.INTERNAL_SERVER_ERROR, message)
fun internalServerError(t: Throwable) = error(HttpStatus.INTERNAL_SERVER_ERROR, t)

fun unsupportedMediaType(t: Throwable) = error(HttpStatus.UNSUPPORTED_MEDIA_TYPE, t)
fun unsupportedMediaType(message: String) = error(HttpStatus.UNSUPPORTED_MEDIA_TYPE, message)

private fun error(status: HttpStatus, message: String): Mono<ServerResponse> {
    val error = Error(status.value(), listOf(message))
    return status(status).body(Mono.just(error))
}

private fun error(status: HttpStatus, t: Throwable): Mono<ServerResponse> {
    val error = Error(status.value(), listOf(t.message ?: status.name))
    return status(status).body(Mono.just(error))
}