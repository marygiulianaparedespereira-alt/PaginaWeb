package etec.bdd.service

import etec.bdd.dto.ClienteRequest
import etec.bdd.entity.Cliente
import etec.bdd.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
open class ClienteService(private val clienteRepository: ClienteRepository) {

    open fun registrar(req: ClienteRequest): Cliente {
        val cliente = Cliente(
            usuario = req.usuario,
            email = req.email,
            contrasena = req.contrasena
        )
        return clienteRepository.save(cliente)
    }

    open fun login(email: String, contrasena: String): Cliente? {
        val cliente = clienteRepository.findByEmail(email)
        if (cliente != null && cliente.contrasena == contrasena) {
            return cliente
        }
        return null
    }
}