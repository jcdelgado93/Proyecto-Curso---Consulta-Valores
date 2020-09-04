package cl.talentodigital.consultavalores.menuListado.data.remote

import com.google.gson.annotations.SerializedName

data class ValoresModel (
    @SerializedName("uf")
    val listaValores: List<ValorModel>? = null
)