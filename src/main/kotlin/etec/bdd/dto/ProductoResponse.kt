package etec.bdd.dto

import etec.bdd.entity.Producto

data class ProductoResponse(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val stock: Int,
    val categoria: String // <-- 1. Agregamos el campo aquí
) {
    companion object {
        fun fromEntity(p: Producto): ProductoResponse =
            ProductoResponse(
                id = p.id.toInt(),
                nombre = p.nombre,
                precio = p.precio.toDouble(),
                stock = p.stock,
                categoria = p.categoria // <-- 2. Mapeamos la categoría desde la entidad
            )
    }
}