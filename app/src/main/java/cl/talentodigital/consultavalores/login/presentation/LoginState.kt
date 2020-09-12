package cl.talentodigital.consultavalores.login.presentation

import cl.talentodigital.consultavalores.login.domain.model.LoginUsuario

sealed class LoginState(
    open val resultLogin: LoginUsuario? = null,
    open val error: Throwable? = null
) {
    object CargandoLoginState : LoginState()
    object UsuarioInvalidoState : LoginState()
    data class LoginExitosoState(override val resultLogin: LoginUsuario?) : LoginState(resultLogin = resultLogin)
    data class ErrorState(override val error: Throwable?) : LoginState(error = error)
}