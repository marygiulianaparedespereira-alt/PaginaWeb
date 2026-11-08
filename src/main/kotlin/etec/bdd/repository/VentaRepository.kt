package etec.bdd.repository

import etec.bdd.entity.Venta
import org.springframework.data.jpa.repository.JpaRepository

interface VentaRepository : JpaRepository<Venta, Long>