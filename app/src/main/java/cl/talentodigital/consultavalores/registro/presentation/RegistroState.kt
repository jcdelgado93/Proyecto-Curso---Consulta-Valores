package cl.talentodigital.consultavalores.registro.presentation

sealed class RegistroState(
    open val result: Boolean? = null,
    open val error: Throwable? = null
) {
    object LoadingRegistroState: RegistroState()
    object SuccessRegistroState : RegistroState(result = true)
    object EmailAlreadyExist : RegistroState(result = false)
    data class ErrorRegistroState(override val error: Throwable) : RegistroState(error = error)
}