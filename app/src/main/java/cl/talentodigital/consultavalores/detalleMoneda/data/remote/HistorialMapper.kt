package cl.talentodigital.consultavalores.detalleMoneda.data.remote

import cl.talentodigital.consultavalores.detalleMoneda.domain.model.Historial
import cl.talentodigital.consultavalores.detalleMoneda.domain.model.InfoHistorial
import cl.talentodigital.consultavalores.menuListado.domain.model.InfoMoneda

class HistorialMapper {

    fun mapToEntityHistorial(historialModel: Array<InfoHistorialModel>): Historial {
        historialModel.apply {
            val listadoHistorial: MutableList<InfoHistorial> = ArrayList()
            listadoHistorial.add(mapToEntityInfoHistorial(historialModel[0]))
            listadoHistorial.add(mapToEntityInfoHistorial(historialModel[1]))
            return Historial(listadoHistorial)
        }
    }

    fun mapToEntityInfoHistorial(infoHistorialModel: InfoHistorialModel) : InfoHistorial {
        return InfoHistorial(
            infoHistorialModel.fecha?: "",
            infoHistorialModel.valor?: 0.0f
        )
    }
}