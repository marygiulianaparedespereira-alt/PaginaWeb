package etec.bdd.controller

import etec.bdd.dto.ClienteRequest
import etec.bdd.entity.Cliente
import etec.bdd.service.ClienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
class AuthController(private val clienteService: ClienteService) {

    @PostMapping("/registro")
    fun registrar(@RequestBody req: ClienteRequest): ResponseEntity<Cliente> {
        val nuevoCliente = clienteService.registrar(req)
        return ResponseEntity.ok(nuevoCliente)
    }

    @PostMapping("/login")
    fun login(@RequestBody req: ClienteRequest): ResponseEntity<Any> {
        // Aseguramos que use los campos correctos (email y contrasena)
        val cliente = clienteService.login(req.email, req.contrasena)
        if (cliente != null) {
            return ResponseEntity.ok(mapOf("mensaje" to "Login exitoso", "usuario" to cliente.usuario))
        }
        return ResponseEntity.status(401).body(mapOf("error" to "Correo o contraseña incorrectos"))
    }
}