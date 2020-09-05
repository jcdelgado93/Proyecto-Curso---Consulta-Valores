package cl.talentodigital.consultavalores.menuListado.presentation

import cl.talentodigital.consultavalores.menuListado.domain.model.Monedas

sealed class ValoresState(
    open val result: Monedas? = null,
    open val error: Throwable? = null
) {
    object LoadingListaValores : ValoresState()
    data class ObtencionDeValores(override val result: Monedas?) : ValoresState(result = result)
    data class Error(override val error: Throwable?) : ValoresState(error = error)
}