package etec.bdd.controller
import etec.bdd.dto.VentaRequest

import etec.bdd.repository.ClienteRepository
import etec.bdd.service.VentaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = ["http://localhost:3000"])
class VentaController(
    private val clienteRepository: ClienteRepository,
    private val ventaService: VentaService
) {

    @PostMapping("/crear")
    fun registrarVenta(@RequestBody ventaDto: VentaRequest): ResponseEntity<Any> {
        // Validación estricta: Nadie compra si no está logueado
        val clienteOpt = clienteRepository.findById(ventaDto.clienteId)
        if (clienteOpt.isEmpty) {
            return ResponseEntity.status(401).body(mapOf("error" to "Debes iniciar sesión para realizar una compra."))
        }

        val nuevaVenta = ventaService.guardarVenta(ventaDto)
        return ResponseEntity.ok(nuevaVenta)
    }
}