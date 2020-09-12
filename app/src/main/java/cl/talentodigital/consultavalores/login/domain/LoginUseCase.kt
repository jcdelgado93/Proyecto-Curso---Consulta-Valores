package cl.talentodigital.consultavalores.login.domain

class LoginUseCase(
    private val loginRepository: LoginRepository
) {
    suspend fun execute(email: String, contrasena: String) = loginRepository.ingresarUsuario(email, contrasena)
}