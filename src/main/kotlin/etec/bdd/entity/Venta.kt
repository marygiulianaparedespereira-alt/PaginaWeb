package etec.bdd.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "venta")
data class Venta(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    val cliente: Cliente,

    @Column(name = "fecha_venta", nullable = false)
    val fechaVenta: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val total: BigDecimal,

    @Column(nullable = false)
    val estado: String = "Pendiente",

    @Column(name = "metodo_pago", nullable = false)
    val metodoPago: String = "Efectivo" // Agregamos esto para los métodos de pago
)