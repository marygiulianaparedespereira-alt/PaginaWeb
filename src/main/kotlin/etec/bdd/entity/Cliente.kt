package etec.bdd.entity

import jakarta.persistence.*

@Entity
@Table(name = "cliente")
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(nullable = false)
    val nombre: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    val telefono: String? = null,
    val direccion: String? = null,

    @Column(nullable = false)
    val rol: String = "COMPRADOR" // Puede ser 'COMPRADOR' o 'ADMIN'
)