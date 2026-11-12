package etec.bdd.controller

import etec.bdd.entity.Cliente
import etec.bdd.repository.ClienteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = ["http://localhost:3000"])
class ClienteController(private val clienteRepository: ClienteRepository) {

    // Obtener todos los clientes (GET)
    @GetMapping
    fun obtenerClientes(): List<Cliente> {
        return clienteRepository.findAll()
    }

    // Obtener un cliente por su ID (GET)
    @GetMapping("/{id}")
    fun obtenerClientePorId(@PathVariable id: Long): ResponseEntity<Cliente> {
        val cliente = clienteRepository.findById(id)
        return if (cliente.isPresent) {
            ResponseEntity.ok(cliente.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}