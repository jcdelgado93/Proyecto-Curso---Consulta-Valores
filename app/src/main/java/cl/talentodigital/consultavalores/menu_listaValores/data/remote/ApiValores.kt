package cl.talentodigital.consultavalores.menu_listaValores.data.remote

import cl.talentodigital.consultavalores.menu_listaValores.domain.model.Valores
import retrofit2.http.GET

interface ApiValores {

    @GET("api")
    suspend fun obtenerValores(): Valores
}