package functional

import functional.common.internalServerError
import functional.users.UserHandler
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.web.reactive.function.server.ServerResponse.permanentRedirect
import org.springframework.web.reactive.function.server.router
import java.net.URI

class Routes(private val userHandler: UserHandler) {

    fun router() = router {
        accept(TEXT_HTML).nest {
            GET("/") { permanentRedirect(URI("index.html")).build() }
        }
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                // The following 2 lines fail to compile with Kotlin 1.3
                // GET("/users", userHandler::findAll)
                // POST("/users", userHandler::create)
                // Instead, I must use the following O.o
                GET("/users") { userHandler.findAll(it) }
                POST("/users") { userHandler.create(it) }
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