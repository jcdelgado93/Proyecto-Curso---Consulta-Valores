package cl.talentodigital.consultavalores.menuListado.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetalleValoresModel(
    val codigo: String? = null,
    val nombre: String? = null,
    @Json(name = "unidad_medida")
    val unidadMedida: String? = null,
    val fecha: String? = null,
    val valor: Float? = null
)