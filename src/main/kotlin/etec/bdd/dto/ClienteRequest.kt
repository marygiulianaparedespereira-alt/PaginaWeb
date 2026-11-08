package etec.bdd.dto

data class ClienteRequest(
    val usuario: String,
    val email: String,
    val contrasena: String
)