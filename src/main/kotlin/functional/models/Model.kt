package functional.models

data class User(val firstname: String, val lastname: String)
data class Error(val code: Int = 400, val messages: List<String>)