package cl.talentodigital.consultavalores.menuListado.domain.model

data class Valor(
    val codigo: String,
    val nombre: String,
    val unidadDeMedida: String,
    val valor: Float
)