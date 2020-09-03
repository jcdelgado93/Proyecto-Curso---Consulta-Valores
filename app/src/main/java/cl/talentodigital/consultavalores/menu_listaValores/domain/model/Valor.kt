package cl.talentodigital.consultavalores.menu_listaValores.domain.model

data class Valor(
    val codigo: String,
    val nombre: String,
    val unidadDeMedida: String,
    val valor: Float
)