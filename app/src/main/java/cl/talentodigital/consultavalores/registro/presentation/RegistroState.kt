package cl.talentodigital.consultavalores.registro.presentation

sealed class RegistroState(
    open val error: Throwable? = null
) {
    object LoadingRegistroState: RegistroState()
    object SuccessRegistroState : RegistroState()
    object EmailAlreadyExist : RegistroState()
    data class ErrorRegistroState(override val error: Throwable) : RegistroState(error = error)
}