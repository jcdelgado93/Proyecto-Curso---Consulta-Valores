package cl.talentodigital.consultavalores.menu_listaValores.data.remote

import cl.talentodigital.consultavalores.menu_listaValores.domain.ValoresRepository
import cl.talentodigital.consultavalores.menu_listaValores.domain.model.Valores

class RemoteValoresRepository(
    private val repository : ApiValores
) : ValoresRepository {

    override suspend fun obtenerValores(): Valores {
        return repository.obtenerValores()
    }
}