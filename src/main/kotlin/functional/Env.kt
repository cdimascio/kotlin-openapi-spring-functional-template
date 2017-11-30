package functional

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.cdimascio.Dotenv

val mapper = jacksonObjectMapper()
val dotenv = Dotenv.configure().useResourceDirectory().build()