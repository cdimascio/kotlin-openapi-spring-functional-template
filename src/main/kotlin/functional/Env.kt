package functional

import functional.models.Error
import io.github.cdimascio.Dotenv
import io.github.cdimascio.swagger.Validate

val validate = Validate.configure("static/api.json") { Error(messages=it) }

val dotenv = Dotenv.configure().useResourceDirectory().build()