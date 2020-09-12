package cl.talentodigital.consultavalores.menuListado.domain

import cl.talentodigital.consultavalores.menuListado.domain.model.Valores

class ObtenerValoresUseCase(
    private val valoresRepository: ValoresRepository
) {
    suspend fun execute() : Valores = valoresRepository.obtenerValores()
}