package functional

import io.cdimascio.Dotenv

val dotenv = Dotenv.configure().useResourceDirectory().build()