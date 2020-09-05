package cl.talentodigital.consultavalores.menuListado.data.remote

import cl.talentodigital.consultavalores.menuListado.domain.ValoresRepository
import cl.talentodigital.consultavalores.menuListado.domain.model.Monedas

class RemoteValoresRepository(
    private val repository : ApiValores,
    private val mapper : Mapper
) : ValoresRepository {

    override suspend fun obtenerMonedas(): Monedas {
        val valores = repository.obtenerMonedas()
        return mapper.mapToEntityMoneda(valores)
    }
}