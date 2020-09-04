package cl.talentodigital.consultavalores.menuListado.data.remote

import cl.talentodigital.consultavalores.menuListado.domain.ValoresRepository
import cl.talentodigital.consultavalores.menuListado.domain.model.Valor
import cl.talentodigital.consultavalores.menuListado.domain.model.Valores

class RemoteValoresRepository(
    private val repository : ApiValores,
    private val mapper : Mapper
) : ValoresRepository {

    override suspend fun obtenerValores(): Valores {
        val valores = repository.obtenerValores()
        val valoresMapeados = valores.listaValores?.map { mapper.mapToEntity(it) } ?: emptyList()
        return Valores(valoresMapeados)
    }
}