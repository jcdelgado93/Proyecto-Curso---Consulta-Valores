package cl.talentodigital.consultavalores.menuListado.data.remote

import retrofit2.http.GET

interface ApiValores {

    @GET("api")
    suspend fun obtenerValores() : ValoresModel
}