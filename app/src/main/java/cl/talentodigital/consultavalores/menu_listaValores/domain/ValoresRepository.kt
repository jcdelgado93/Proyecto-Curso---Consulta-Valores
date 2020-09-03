package cl.talentodigital.consultavalores.menu_listaValores.domain

import cl.talentodigital.consultavalores.menu_listaValores.domain.model.Valores

interface ValoresRepository {
    suspend fun obtenerValores(): Valores
}