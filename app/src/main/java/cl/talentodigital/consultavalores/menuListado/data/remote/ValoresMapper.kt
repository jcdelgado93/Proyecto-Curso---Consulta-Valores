package cl.talentodigital.consultavalores.menuListado.data.remote

import cl.talentodigital.consultavalores.menuListado.domain.model.*

class ValoresMapper {

    fun mapToEntityValores(monedaModel: ValoresModel): Valores {
        monedaModel.apply {
            val listadoMonedas: MutableList<DetalleValores> = ArrayList()
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.uf))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.ivp))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.dolar))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.dolarIntercambio))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.euro))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.ipc))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.utm))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.imacec))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.tpm))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.libraCobre))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.tasaDesempleo))
            listadoMonedas.add(mapToEntityDetalleValores(monedaModel.bitcoin))
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