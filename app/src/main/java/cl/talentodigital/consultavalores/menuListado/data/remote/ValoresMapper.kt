package cl.talentodigital.consultavalores.menuListado.data.remote

import cl.talentodigital.consultavalores.menuListado.domain.model.*

class ValoresMapper {

    fun mapToEntityValores(monedaModel: ValoresModel): Valores {
        monedaModel.apply {
            val listadoMonedas: MutableList<DetalleValores> = ArrayList()
            listadoMonedas.add(mapToEntityDetalleValores(uf))
            listadoMonedas.add(mapToEntityDetalleValores(ivp))
            listadoMonedas.add(mapToEntityDetalleValores(dolar))
            listadoMonedas.add(mapToEntityDetalleValores(dolarIntercambio))
            listadoMonedas.add(mapToEntityDetalleValores(euro))
            listadoMonedas.add(mapToEntityDetalleValores(ipc))
            listadoMonedas.add(mapToEntityDetalleValores(utm))
            listadoMonedas.add(mapToEntityDetalleValores(imacec))
            listadoMonedas.add(mapToEntityDetalleValores(tpm))
            listadoMonedas.add(mapToEntityDetalleValores(libraCobre))
            listadoMonedas.add(mapToEntityDetalleValores(tasaDesempleo))
            listadoMonedas.add(mapToEntityDetalleValores(bitcoin))
            return Valores(listadoMonedas)
        }
    }

    fun mapToEntityDetalleValores(detalleValoresModel: DetalleValoresModel) : DetalleValores {
        return DetalleValores(
            detalleValoresModel.codigo,
            detalleValoresModel.nombre,
            detalleValoresModel.unidadMedida,
            detalleValoresModel.fecha,
            detalleValoresModel.valor
        )
    }
}