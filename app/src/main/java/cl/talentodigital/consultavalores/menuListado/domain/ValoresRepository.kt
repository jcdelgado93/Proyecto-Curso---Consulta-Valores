package cl.talentodigital.consultavalores.menuListado.domain

import cl.talentodigital.consultavalores.menuListado.domain.model.Valores

interface ValoresRepository {
    suspend fun obtenerValores(): Valores
}