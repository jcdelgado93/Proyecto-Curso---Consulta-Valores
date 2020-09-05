package cl.talentodigital.consultavalores.menuListado.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MonedasModel(
    val version: String,
    val autor: String,
    val fecha: String,
    val uf: InfoMonedaModel,
    val ivp: InfoMonedaModel,
    val dolar: InfoMonedaModel,
    @Json(name = "dolar_intercambio")
    val dolarIntercambio: InfoMonedaModel,
    val euro: InfoMonedaModel,
    val ipc: InfoMonedaModel,
    val utm: InfoMonedaModel,
    val imacec: InfoMonedaModel,
    val tpm: InfoMonedaModel,
    @Json(name = "libra_cobre")
    val libraCobre: InfoMonedaModel,
    @Json(name = "tasa_desempleo")
    val tasaDesempleo: InfoMonedaModel,
    val bitcoin: InfoMonedaModel
)