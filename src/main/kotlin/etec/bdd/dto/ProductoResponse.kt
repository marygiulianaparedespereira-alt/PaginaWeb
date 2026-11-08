package etec.bdd.dto

import etec.bdd.entity.Producto

data class ProductoResponse(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val stock: Int,
    val categoria: String,
    val imagen: String? // <-- 1. Agregamos la propiedad de la imagen
) {
    companion object {
        fun fromEntity(p: Producto): ProductoResponse =
            ProductoResponse(
                id = p.id.toInt(),
                nombre = p.nombre,
                precio = p.precio.toDouble(),
                stock = p.stock,
                categoria = p.categoria,
                imagen = p.imagen // <-- 2. Mapeamos la imagen desde la entidad
            )
    }
}