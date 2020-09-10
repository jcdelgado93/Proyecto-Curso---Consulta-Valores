package cl.talentodigital.consultavalores.menuListado.data.remote

import cl.talentodigital.consultavalores.menuListado.domain.ValoresRepository
import cl.talentodigital.consultavalores.menuListado.domain.model.Monedas

class RemoteValoresRepository(
    private val repository : ApiValores,
    private val valoresMapper : ValoresMapper
) : ValoresRepository {

    override suspend fun obtenerMonedas(): Monedas {
        val valores = repository.obtenerMonedas()
        return valoresMapper.mapToEntityMoneda(valores)
    }
}