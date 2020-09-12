package cl.talentodigital.consultavalores.detalleMoneda.domain

import cl.talentodigital.consultavalores.detalleMoneda.domain.model.Historial

class ObtenerHistorialUseCase(
    private val repository : HistorialRepository
) {
    suspend fun execute(tipoDeMoneda : String, anio : String) : Historial = repository.obtenerHistorialPorAnio(tipoDeMoneda, anio)
}