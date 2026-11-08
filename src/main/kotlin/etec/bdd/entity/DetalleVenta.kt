package etec.bdd.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "detalle_venta")
data class DetalleVenta(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    val venta: Venta,

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    val producto: Producto,

    @Column(nullable = false)
    val cantidad: Int,

    @Column(name = "precio_unitario", nullable = false)
    val precioUnitario: BigDecimal
)