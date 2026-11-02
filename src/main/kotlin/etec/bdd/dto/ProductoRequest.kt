
package etec.bdd.dto

import jakarta.validation.constraints.*
import java.math.BigDecimal

data class ProductoRequest(
    @field:NotBlank
    @field:Size(min = 1, max = 120)
    val nombre: String,

    @field:NotNull
    @field:DecimalMin(value = "0.0", inclusive = true)
    val precio: BigDecimal,

    @field:NotNull
    @field:Min(0)
    val stock: Int
)