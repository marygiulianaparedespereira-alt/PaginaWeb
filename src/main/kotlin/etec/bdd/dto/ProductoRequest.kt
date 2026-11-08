package etec.bdd.dto

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

data class ProductoRequest(
    @field:NotBlank(message = "El nombre no puede estar vacío")
    @field:Size(max = 100)
    val nombre: String,

    @field:NotNull
    @field:DecimalMin("0.0")
    val precio: BigDecimal,

    @field:NotNull
    @field:Min(0)
    val stock: Int,


    @field:NotBlank(message = "La categoría no puede estar vacía")
    val categoria: String
)