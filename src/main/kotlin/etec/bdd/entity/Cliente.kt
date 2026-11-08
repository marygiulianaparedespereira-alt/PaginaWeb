package etec.bdd.entity

import jakarta.persistence.*

@Entity
@Table(name = "cliente")
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val usuario: String,

    @Column(unique = true)
    val email: String,

    val contrasena: String,

    val rol: String = "CLIENTE" // "ADMIN" para gestión interna, "CLIENTE" para compradores
)