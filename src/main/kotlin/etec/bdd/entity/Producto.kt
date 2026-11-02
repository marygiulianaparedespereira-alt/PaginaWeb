package etec.bdd.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Column
import java.math.BigDecimal

@Entity
@Table(name = "productos")
class Producto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column(nullable = false, length = 120)
    val nombre: String,

    @Column(nullable = false, precision = 10, scale = 2)
    val precio: BigDecimal,

    @Column(nullable = false)
    val stock: Int
)