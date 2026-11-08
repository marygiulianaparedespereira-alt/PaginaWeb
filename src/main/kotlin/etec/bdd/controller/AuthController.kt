package etec.bdd.controller

import etec.bdd.entity.Cliente
import etec.bdd.repository.ClienteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class LoginRequest(
    val usuario: String,
    val contrasena: String
)

data class RegistroRequest(
    val usuario: String,
    val email: String,
    val contrasena: String
)

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = ["http://localhost:3000"])
class AuthController(private val clienteRepository: ClienteRepository) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        val clienteOpt = clienteRepository.findByUsuario(request.usuario)

        if (clienteOpt.isPresent) {
            val cliente = clienteOpt.get()
            if (cliente.contrasena == request.contrasena) {
                return ResponseEntity.ok(mapOf(
                    "mensaje" to "Login exitoso",
                    "rol" to cliente.rol,
                    "usuario" to cliente.usuario
                ))
            }
        }
        return ResponseEntity.status(401).body(mapOf("error" to "Usuario o contraseña incorrectos"))
    }

    // --- ENDPOINT PARA REGISTRAR NUEVOS CLIENTES ---
    @PostMapping("/registro")
    fun registrar(@RequestBody request: RegistroRequest): ResponseEntity<Any> {
        // Verificamos si el usuario ya existe
        if (clienteRepository.findByUsuario(request.usuario).isPresent) {
            return ResponseEntity.status(400).body(mapOf("error" to "El nombre de usuario ya está registrado"))
        }

        // Creamos el nuevo cliente con rol "CLIENTE" y lo guardamos en MariaDB
        val nuevoCliente = Cliente(
            usuario = request.usuario,
            email = request.email,
            contrasena = request.contrasena,
            rol = "CLIENTE"
        )

        clienteRepository.save(nuevoCliente)

        return ResponseEntity.ok(mapOf(
            "mensaje" to "Usuario registrado con éxito",
            "usuario" to nuevoCliente.usuario,
            "rol" to nuevoCliente.rol
        ))
    }
}