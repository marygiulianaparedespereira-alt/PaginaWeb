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
    var nombre: String,

    @Column(nullable = false)
    var precio: BigDecimal,

    @Column(nullable = false)
    var stock: Int,

    @Column(nullable = false)
    var categoria: String,

    var imagen: String? = null
)