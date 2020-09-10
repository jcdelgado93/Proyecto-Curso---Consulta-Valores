package cl.talentodigital.consultavalores.menuListado.data.remote

import cl.talentodigital.consultavalores.menuListado.domain.model.*

class ValoresMapper {

    fun mapToEntityMoneda(monedaModel: MonedasModel): Monedas {
        monedaModel.apply {
            val listadoMonedas: MutableList<InfoMoneda> = ArrayList()
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.uf))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.ivp))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.dolar))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.dolarIntercambio))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.euro))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.ipc))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.utm))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.imacec))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.tpm))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.libraCobre))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.tasaDesempleo))
            listadoMonedas.add(mapToEntityInfoMoneda(monedaModel.bitcoin))
            return Monedas(listadoMonedas)
        }
    }

    fun mapToEntityInfoMoneda(infoMonedaModel: InfoMonedaModel) : InfoMoneda {
        return InfoMoneda(
            infoMonedaModel.codigo,
            infoMonedaModel.nombre,
            infoMonedaModel.unidadMedida,
            infoMonedaModel.fecha,
            infoMonedaModel.valor
        )
    }
}