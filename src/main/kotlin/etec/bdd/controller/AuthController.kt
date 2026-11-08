package etec.bdd.controller

import etec.bdd.repository.ClienteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = ["http://localhost:3000"])
class AuthController(private val clienteRepository: ClienteRepository) {

    data class LoginRequest(val email: String, val password: String)

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        val cliente = clienteRepository.findByEmail(request.email)

        if (cliente != null && cliente.password == request.password) {
            return ResponseEntity.ok(mapOf(
                "mensaje" to "Login exitoso",
                "nombre" to cliente.nombre,
                "email" to cliente.email,
                "rol" to cliente.rol
            ))
        }

        return ResponseEntity.status(401).body(mapOf("error" to "Credenciales inválidas"))
    }
}