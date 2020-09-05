package cl.talentodigital.consultavalores.menuListado.domain

import cl.talentodigital.consultavalores.menuListado.domain.model.Monedas

interface ValoresRepository {
    suspend fun obtenerMonedas(): Monedas
}