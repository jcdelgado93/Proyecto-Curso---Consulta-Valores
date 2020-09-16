package cl.talentodigital.consultavalores.menuListado.domain

class EliminarFavoritosUseCase(
    private val repository: ValoresRepository
) {
    suspend fun execute() = repository.eliminarFavoritos()
}