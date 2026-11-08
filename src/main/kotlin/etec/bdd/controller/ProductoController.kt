package etec.bdd.controller

import etec.bdd.dto.ProductoRequest
import etec.bdd.dto.ProductoResponse
import etec.bdd.service.ProductoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = ["http://localhost:3000"])
class ProductoController(private val productoService: ProductoService) {

    // Listar todos los productos
    @GetMapping
    fun obtenerTodos(): ResponseEntity<List<ProductoResponse>> {
        val productos = productoService.obtenerTodos()
        return ResponseEntity.ok(productos)
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<ProductoResponse> {
        val producto = productoService.obtenerPorId(id)
        if (producto != null) {
            return ResponseEntity.ok(producto)
        }
        return ResponseEntity.notFound().build()
    }

    // Crear un producto
    @PostMapping
    fun crear(@RequestBody request: ProductoRequest): ResponseEntity<ProductoResponse> {
        val nuevoProducto = productoService.crear(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto)
    }

    // Actualizar / Modificar un producto
    @PutMapping("/{id}")
    fun actualizar(
        @PathVariable id: Long,
        @RequestBody request: ProductoRequest
    ): ResponseEntity<ProductoResponse> {
        val productoActualizado = productoService.actualizar(id, request)
        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado)
        }
        return ResponseEntity.notFound().build()
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long): ResponseEntity<Void> {
        val eliminado = productoService.eliminar(id)
        if (eliminado) {
            return ResponseEntity.noContent().build()
        }
        return ResponseEntity.notFound().build()
    }
}