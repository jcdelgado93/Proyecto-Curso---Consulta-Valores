package cl.talentodigital.consultavalores.menuListado.domain

import cl.talentodigital.consultavalores.menuListado.domain.model.DetalleValores
import cl.talentodigital.consultavalores.menuListado.domain.model.Valores

interface ValoresRepository {
    suspend fun obtenerValoresApi(): Valores
    suspend fun guardarFavorito(detalleValores: DetalleValores): Boolean
    suspend fun eliminarFavoritos()
}