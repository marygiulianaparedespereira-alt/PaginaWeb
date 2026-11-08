package etec.bdd.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "producto")
data class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(nullable = false)
    val nombre: String,

    @Column(nullable = false)
    val precio: BigDecimal,

    @Column(nullable = false)
    val stock: Int,

    @Column(nullable = false)
    val categoria: String,

    val imagen: String? = null
)