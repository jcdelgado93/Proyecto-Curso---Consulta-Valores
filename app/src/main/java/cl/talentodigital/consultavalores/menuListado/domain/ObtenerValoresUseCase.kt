package cl.talentodigital.consultavalores.menuListado.domain

import cl.talentodigital.consultavalores.menuListado.domain.model.Monedas

class ObtenerValoresUseCase(
    private val repository: ValoresRepository
) {
    suspend fun execute() : Monedas = repository.obtenerMonedas()
}