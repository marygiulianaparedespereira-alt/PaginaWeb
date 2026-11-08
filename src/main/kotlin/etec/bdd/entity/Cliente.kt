package etec.bdd.entity

import jakarta.persistence.*

@Entity
@Table(name = "cliente")
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val usuario: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val contrasena: String,

    @Column(nullable = false)
    val rol: String = "CLIENTE",

    @Column(nullable = true)
    val nombre: String? = null
)