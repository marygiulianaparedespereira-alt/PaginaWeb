package etec.bdd.service

import etec.bdd.dto.VentaRequest
import etec.bdd.entity.Venta
import etec.bdd.repository.ClienteRepository
import etec.bdd.repository.VentaRepository
import org.springframework.stereotype.Service

@Service
class VentaService(
    private val ventaRepository: VentaRepository,
    private val clienteRepository: ClienteRepository
) {

    fun guardarVenta(request: VentaRequest): Venta {
        val cliente = clienteRepository.findById(request.clienteId)
            .orElseThrow { RuntimeException("Cliente no encontrado") }

        val nuevaVenta = Venta(
            cliente = cliente,
            total = request.total.toBigDecimal()
        )
        return ventaRepository.save(nuevaVenta)
    }

    fun listarVentas(): List<Venta> {
        return ventaRepository.findAll()
    }
}