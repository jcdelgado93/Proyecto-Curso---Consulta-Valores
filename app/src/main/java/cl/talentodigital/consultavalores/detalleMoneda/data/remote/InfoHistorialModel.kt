package cl.talentodigital.consultavalores.detalleMoneda.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InfoHistorialModel(
    val fecha : String? = null,
    val valor : Float? = null
)