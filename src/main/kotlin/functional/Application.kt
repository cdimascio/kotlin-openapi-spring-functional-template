package functional

import functional.common.beans
import functional.common.dotenv
import org.springframework.context.support.GenericApplicationContext
import org.springframework.http.server.reactive.HttpHandler
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter
import org.springframework.web.server.adapter.WebHttpHandlerBuilder
import reactor.netty.DisposableServer
import reactor.netty.http.server.HttpServer
// import reactor.ipc.netty.http.server.HttpServer
// import reactor.ipc.netty.tcp.BlockingNettyContext
//import reactor.netty.http.server.HttpServer
import java.time.Duration

class Application(port: Int = dotenv["PORT"]?.toInt() ?: 8080) {

    private val httpHandler: HttpHandler
    private val server: HttpServer
    //    private var nettyContext: BlockingNettyContext? = null
    private var disposableServer: DisposableServer? = null

    fun start() {
//        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
//        HttpServer.create("0.0.0.0", this.port).newHandler(handler).block()
//        nettyContext = server.start(ReactorHttpHandlerAdapter(httpHandler))
//        val adapter = ReactorHttpHandlerAdapter(handler)
//        server.newHandler(adapter)


        server.bindUntilJavaShutdown(Duration.ofSeconds(5)) {
            disposableServer = it
        }
    }

    fun startAndAwait() {
//        serverstartAndAwait(ReactorHttpHandlerAdapter(httpHandler)) { nettyContext = it }
//        server.
        start()
    }

    fun stop() {
//        nettyContext?.shutdown()
        disposableServer?.disposeNow()
    }

    init {
        val context = GenericApplicationContext().apply {
            beans().initialize(this)
            refresh()
        }
        httpHandler = WebHttpHandlerBuilder.applicationContext(context).build()
        val adapter = ReactorHttpHandlerAdapter(httpHandler)
        server = HttpServer.create().handle(adapter).port(port) // port)
//        server.port(port)

//        server.handle(adapter)
//        println(server)
//        server.

//        httpHandler = WebHttpHandlerBuilder.applicationContext(context).build()
    }
}

fun main(args: Array<String>) {
    Application().startAndAwait()
}