package cl.talentodigital.consultavalores.menuListado.presentation

import cl.talentodigital.consultavalores.menuListado.domain.model.Valores

sealed class ValoresState(
    open val result: Valores? = null,
    open val error: Throwable? = null
) {
    object LoadingListaValores : ValoresState()
    data class ObtencionDeValores(override val result: Valores?) : ValoresState(result = result)
    data class Error(override val error: Throwable?) : ValoresState(error = error)
}