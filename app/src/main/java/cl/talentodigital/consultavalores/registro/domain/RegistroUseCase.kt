package cl.talentodigital.consultavalores.registro.domain

import cl.talentodigital.consultavalores.registro.domain.model.RegistroUsuario

class RegistroUseCase(
    private val repository: RegistroRepository
) {
    suspend fun execute(registroUsuario: RegistroUsuario) = repository.registrar(registroUsuario)
}