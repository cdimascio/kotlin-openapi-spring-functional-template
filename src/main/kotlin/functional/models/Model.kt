package functional.models

data class User(val firstname: String, val lastname: String)
data class Error(val code: Int, val messages: List<String>)