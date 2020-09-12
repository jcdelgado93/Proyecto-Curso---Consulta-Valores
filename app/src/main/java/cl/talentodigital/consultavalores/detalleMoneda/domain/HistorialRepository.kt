package cl.talentodigital.consultavalores.detalleMoneda.domain

import cl.talentodigital.consultavalores.detalleMoneda.domain.model.Historial

interface HistorialRepository {
    suspend fun obtenerHistorialPorAnio(tipoDeMoneda : String, anio : String): Historial
}