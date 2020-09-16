package cl.talentodigital.consultavalores.menuListado.data.remote

import cl.talentodigital.consultavalores.menuListado.domain.ValoresRepository
import cl.talentodigital.consultavalores.menuListado.domain.model.Valores

class RemoteValoresRepository(
    private val apiRepository : ApiValores,
    private val valoresMapper : ValoresMapper
) : ValoresRepository {

    override suspend fun obtenerValoresApi(): Valores {
        val valores = apiRepository.obtenerMonedas()
        return valoresMapper.mapToEntityValores(valores)
    }
}