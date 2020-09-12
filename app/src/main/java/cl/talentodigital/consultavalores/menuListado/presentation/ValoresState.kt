package cl.talentodigital.consultavalores.menuListado.presentation

import cl.talentodigital.consultavalores.menuListado.domain.model.DetalleValores
import cl.talentodigital.consultavalores.menuListado.domain.model.Valores

sealed class ValoresState(
    open val resultValores: Valores? = null,
    open val resultDetalleValores: DetalleValores? = null,
    open val error: Throwable? = null
) {
    object CargandoListaDeValoresState : ValoresState()
    data class ObtenerTodosLosValores(override val resultValores: Valores?) : ValoresState(resultValores = resultValores)
    data class ObtenerDetalleDeUnValor(override val resultDetalleValores: DetalleValores?) : ValoresState(resultDetalleValores = resultDetalleValores)
    data class Error(override val error: Throwable?) : ValoresState(error = error)
}