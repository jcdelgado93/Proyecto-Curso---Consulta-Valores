package cl.talentodigital.consultavalores.login.domain

import cl.talentodigital.consultavalores.login.domain.model.LoginUsuario

interface LoginRepository {
    suspend fun ingresarUsuario(email: String, contrasena: String): LoginUsuario
}