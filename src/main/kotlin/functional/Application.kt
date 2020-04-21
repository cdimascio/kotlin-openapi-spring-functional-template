package functional

import functional.common.beans
import functional.common.dotenv
import java.time.Duration
import org.springframework.context.support.GenericApplicationContext
import org.springframework.http.server.reactive.HttpHandler
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter
import org.springframework.web.server.adapter.WebHttpHandlerBuilder
import reactor.netty.DisposableServer
import reactor.netty.http.server.HttpServer

class Application(port: Int = dotenv["PORT"]?.toInt() ?: 8080) {

    private val httpHandler: HttpHandler
    private val server: HttpServer
    private var disposableServer: DisposableServer? = null

    fun start() {
        disposableServer = server.bindNow(Duration.ofSeconds(5))
    }

    fun startAndAwait() {
        server.bindUntilJavaShutdown(Duration.ofSeconds(5)) {
            disposableServer = it
        }
    }

    fun stop() {
        disposableServer?.disposeNow()
    }

    init {
        val context = GenericApplicationContext().apply {
            beans().initialize(this)
            refresh()
        }
        httpHandler = WebHttpHandlerBuilder.applicationContext(context).build()
        val adapter = ReactorHttpHandlerAdapter(httpHandler)
        server = HttpServer.create().host("localhost").handle(adapter).port(port) // port)
    }
}

fun main(args: Array<String>) {
    Application().startAndAwait()
}