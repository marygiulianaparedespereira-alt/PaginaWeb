package etec.bdd.dto

import etec.bdd.entity.Producto

data class ProductoResponse(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val stock: Int,
) {
    companion object {
        fun fromEntity(p: Producto): ProductoResponse =
            ProductoResponse(
                id = p.id.toInt(),
                nombre = p.nombre,
                precio = p.precio.toDouble(),
                stock = p.stock,
            )
    }
}