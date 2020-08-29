package cl.talentodigital.consultavalores.registro.domain

import cl.talentodigital.consultavalores.registro.domain.model.RegistroUsuario

interface RegistroRepository {
    suspend fun registrar(registro: RegistroUsuario): Boolean
}