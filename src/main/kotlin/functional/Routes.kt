package functional

import functional.common.internalServerError
import functional.users.UserHandler
import java.net.URI
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.web.reactive.function.server.ServerResponse.permanentRedirect
import org.springframework.web.reactive.function.server.router

class Routes(private val userHandler: UserHandler) {

    fun router() = router {
        accept(TEXT_HTML).nest {
            GET("/") { permanentRedirect(URI("index.html")).build() }
        }
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/users", userHandler::findAll)
                POST("/users", userHandler::create)
            }
        }
        resources("/**", ClassPathResource("static/"))
    }
    .filter { request, next ->
        try {
            next.handle(request)
        } catch (ex: Exception) {
            internalServerError(ex)
        }
    }
}