package cl.talentodigital.consultavalores.detalleMoneda.presentation

import cl.talentodigital.consultavalores.detalleMoneda.domain.model.Historial

sealed class HistorialState(
    open val resultListadoHistorial : Historial? = null,
    open val error : Throwable? = null
) {
    object LoadingListaHistorial : HistorialState()
    data class ObtenerHistorialDeValores(override  val resultListadoHistorial: Historial?) : HistorialState(resultListadoHistorial = resultListadoHistorial)
    data class Error(override val error : Throwable?) : HistorialState(error = error)
}