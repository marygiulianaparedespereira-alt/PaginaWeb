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
            imagen = req.imagen // <-- Incluimos la imagen al crear el producto
        )
        val guardado = productoRepository.save(nuevoProducto)
        return ProductoResponse.fromEntity(guardado)
    }
}