package functional.controllers


import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType.*
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
                GET("/users", userHandler::findAll)
            }
            accept(APPLICATION_JSON).nest {
                POST("/users", userHandler::create)
            }

        }
        resources("/**", ClassPathResource("static/"))
    }
}