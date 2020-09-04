package cl.talentodigital.consultavalores.menuListado.domain

import cl.talentodigital.consultavalores.menuListado.domain.model.Valores

class ValoresUseCase(
    private val repository: ValoresRepository
) {
    suspend fun execute() : Valores = repository.obtenerValores()
}