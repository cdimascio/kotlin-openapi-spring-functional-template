package functional.common

import functional.Routes
import functional.users.UserHandler
import functional.users.UserService
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.server.adapter.WebHttpHandlerBuilder

fun beans() = beans {
    bean<UserHandler>()
    bean<UserService>()
    bean<Routes>()
    bean(WebHttpHandlerBuilder.WEB_HANDLER_BEAN_NAME) {
        RouterFunctions.toWebHandler(ref<Routes>().router())
    }
}

class Foo