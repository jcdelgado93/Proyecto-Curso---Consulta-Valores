package cl.talentodigital.consultavalores.menuListado.domain

import cl.talentodigital.consultavalores.menuListado.domain.model.DetalleValores

class GuardarFavoritoUseCase(
    private val repository: ValoresRepository
) {
    suspend fun execute(detalleValores: DetalleValores) : Boolean = repository.guardarFavorito(detalleValores)
}