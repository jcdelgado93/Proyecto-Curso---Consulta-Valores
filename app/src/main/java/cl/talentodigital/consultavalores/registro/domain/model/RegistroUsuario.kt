package cl.talentodigital.consultavalores.registro.domain.model

data class RegistroUsuario(
    val nombre: String,
    val rut: String,
    val email: String,
    val contrasena: String
)