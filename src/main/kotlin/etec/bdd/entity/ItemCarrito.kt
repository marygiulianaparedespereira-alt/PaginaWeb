package etec.bdd.entity

import jakarta.persistence.*

@Entity
@Table(name = "carrito")
data class ItemCarrito(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    val cliente: Cliente,

    @ManyToOne
    @JoinColumn(name = "producto_id")
    val producto: Producto,

    val cantidad: Int
)