package cl.talentodigital.consultavalores.login.domain

class LoginUseCase(
    private val repository: LoginRepository
) {
    suspend fun execute(email: String, contrasena: String) = repository.doLogin(email, contrasena)
}