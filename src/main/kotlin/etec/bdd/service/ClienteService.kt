package etec.bdd.service

import etec.bdd.entity.Cliente
import etec.bdd.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(private val clienteRepository: ClienteRepository) {

    fun registrar(cliente: Cliente): Cliente {
        return clienteRepository.save(cliente)
    }

    fun buscarPorUsuario(usuario: String): Cliente? {
        return clienteRepository.findByUsuario(usuario).orElse(null)
    }

    fun login(usuario: String, contrasena: String): Cliente? {
        val cliente = clienteRepository.findByUsuario(usuario).orElse(null)
        if (cliente != null && cliente.contrasena == contrasena) {
            return cliente
        }
        return null
    }
}