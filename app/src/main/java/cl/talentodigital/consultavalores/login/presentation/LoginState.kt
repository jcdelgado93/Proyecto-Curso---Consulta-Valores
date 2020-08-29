package cl.talentodigital.consultavalores.login.presentation

import cl.talentodigital.consultavalores.login.domain.model.LoginUsuario

sealed class LoginState(
    open val result: LoginUsuario? = null,
    open val error: Throwable? = null
) {
    object LoadingLogin : LoginState()
    data class SuccessLogin(override val result: LoginUsuario?) : LoginState(result = result)
    data class Error(override val error: Throwable?) : LoginState(error = error)
    object InvalidUser : LoginState()
}