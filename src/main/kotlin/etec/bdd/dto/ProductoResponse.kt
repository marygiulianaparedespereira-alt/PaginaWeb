package etec.bdd.dto

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import etec.bdd.entity.Producto
import java.math.BigDecimal

data class ProductoResponse(
    val id: Int,

    val nombre: String,

    @JsonSerialize(using = ToStringSerializer::class)
    val precio: BigDecimal,

    val stock: Int,
) {
    companion object {
        fun fromEntity(p: Producto): ProductoResponse =
            ProductoResponse(
                id = p.id ?: 0,
                nombre = p.nombre,
                precio = p.precio,
                stock = p.stock,
            )
    }
}