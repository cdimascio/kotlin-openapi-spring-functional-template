package functional

import functional.controllers.Routes
import functional.controllers.UserHandler
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.RouterFunctions

fun beans() = beans {
	bean<UserHandler>()
	bean<Routes>()
	bean("webHandler") {
		RouterFunctions.toWebHandler(ref<Routes>().router())
	}
	profile("foo") {
		bean<Foo>()
	}
}

class Foo