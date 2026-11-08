package etec.bdd.repository

import etec.bdd.entity.ItemCarrito
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemCarritoRepository : JpaRepository<ItemCarrito, Long> {
    fun findByClienteId(clienteId: Long): List<ItemCarrito>
}