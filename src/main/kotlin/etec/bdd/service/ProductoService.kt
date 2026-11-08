package etec.bdd.service

import etec.bdd.dto.ProductoRequest
import etec.bdd.dto.ProductoResponse
import etec.bdd.entity.Producto
import etec.bdd.repository.ProductoRepository
import org.springframework.stereotype.Service

@Service
open class ProductoService(private val productoRepository: ProductoRepository) {

    open fun obtenerTodos(): List<ProductoResponse> {
        return productoRepository.findAll().map { ProductoResponse.fromEntity(it) }
    }

    open fun obtenerPorId(id: Long): ProductoResponse? {
        val producto = productoRepository.findById(id.toInt()).orElse(null)
        return producto?.let { ProductoResponse.fromEntity(it) }
    }

    open fun crear(req: ProductoRequest): ProductoResponse {
        val nuevoProducto = Producto(
            nombre = req.nombre,
            precio = req.precio,
            stock = req.stock,
            categoria = req.categoria,
            imagen = req.imagen
        )
        val guardado = productoRepository.save(nuevoProducto)
        return ProductoResponse.fromEntity(guardado)
    }

    open fun actualizar(id: Long, req: ProductoRequest): ProductoResponse? {
        val existe = productoRepository.findById(id.toInt())
        if (existe.isPresent) {
            val producto = existe.get()
            // Nota: Si te vuelve a marcar que "Val cannot be reassigned",
            // asegúrate de que en tu entidad Producto.kt los campos usen 'var' en lugar de 'val'.
            producto.nombre = req.nombre
            producto.precio = req.precio
            producto.stock = req.stock
            producto.categoria = req.categoria
            producto.imagen = req.imagen

            val actualizado = productoRepository.save(producto)
            return ProductoResponse.fromEntity(actualizado)
        }
        return null
    }

    open fun eliminar(id: Long): Boolean {
        val idAsInt = id.toInt()
        if (productoRepository.existsById(idAsInt)) {
            productoRepository.deleteById(idAsInt)
            return true
        }
        return false
    }
}