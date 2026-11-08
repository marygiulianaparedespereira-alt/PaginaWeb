package etec.bdd.repository

import etec.bdd.entity.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ClienteRepository : JpaRepository<Cliente, Long> {
    fun findByUsuario(usuario: String): Optional<Cliente>
    fun findByEmail(email: String): Optional<Cliente> // <-- Agregamos esta línea para que Spring la reconozca
}