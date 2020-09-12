package cl.talentodigital.consultavalores.detalleMoneda.data.remote

import cl.talentodigital.consultavalores.detalleMoneda.domain.HistorialRepository
import cl.talentodigital.consultavalores.detalleMoneda.domain.model.Historial

class RemoteHistorialRepository(
    private val repository : ApiHistorialDeValores,
    private val historialMapper : HistorialMapper
) : HistorialRepository {

    override suspend fun obtenerHistorialPorAnio(
        tipoDeMoneda: String, anio: String
    ): Historial {
        val historial = repository.obtenerHistorialDeValores(tipoDeMoneda, anio)
        return historialMapper.mapToEntityHistorial(historial)
    }
}