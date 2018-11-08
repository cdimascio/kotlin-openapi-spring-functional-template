package functional.users

data class User(val firstname: String, val lastname: String)
data class UsersEnvelope(val users: List<User>)