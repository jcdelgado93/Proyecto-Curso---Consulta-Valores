package cl.talentodigital.consultavalores.login.domain

import cl.talentodigital.consultavalores.login.domain.model.LoginUsuario

interface LoginRepository {
    suspend fun doLogin(email: String, contrasena: String): LoginUsuario
}