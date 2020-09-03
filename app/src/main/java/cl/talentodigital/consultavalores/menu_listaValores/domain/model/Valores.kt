package cl.talentodigital.consultavalores.menu_listaValores.domain.model

import com.google.gson.annotations.SerializedName

data class Valores(
    @SerializedName("uf")
    val listaValores: List<Valor>
)