package cl.talentodigital.consultavalores.menuListado.data.remote

import cl.talentodigital.consultavalores.menuListado.domain.model.Valor

class Mapper {

    fun mapToEntity(valorModel: ValorModel): Valor {
        valorModel.apply {
            return Valor(
                codigo?: "",
                nombre?: "",
                unidadDeMedida?: "",
                valor?: 0.0f
            )
        }
    }
}