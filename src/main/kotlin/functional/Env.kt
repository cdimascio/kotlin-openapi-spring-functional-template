package functional

import functional.models.Error
import io.github.cdimascio.dotenv.dotenv
import io.github.cdimascio.swagger.Validate

val validate = Validate.configure("static/api.json") { status, messages ->
    Error(status.value(), messages)
}

val dotenv = dotenv()