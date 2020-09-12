package cl.talentodigital.consultavalores.login.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import cl.talentodigital.consultavalores.R
import cl.talentodigital.consultavalores.databinding.FragmentLoginBinding
import cl.talentodigital.consultavalores.login.data.remote.FirebaseLoginRepository
import cl.talentodigital.consultavalores.login.domain.LoginUseCase
import cl.talentodigital.consultavalores.login.presentation.LoginState
import cl.talentodigital.consultavalores.login.presentation.LoginViewModel
import cl.talentodigital.consultavalores.login.presentation.LoginViewModelFactory
import cl.talentodigital.consultavalores.util.extentions.alert
import cl.talentodigital.consultavalores.util.validator.EmailValidator
import cl.talentodigital.consultavalores.util.validator.PassValidator
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginViewModelFactory: LoginViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        setupBinding(view)
        setupLiveData()
        setupListeners()
    }

    private fun setupDependencies() {
        loginViewModelFactory = LoginViewModelFactory(
            LoginUseCase(
                FirebaseLoginRepository(
                    FirebaseAuth.getInstance()
                )
            )
        )

        loginViewModel = ViewModelProvider(this, loginViewModelFactory)
            .get(LoginViewModel::class.java)
    }

    private fun setupBinding(view: View) {
        binding = FragmentLoginBinding.bind(view)
    }

    private fun setupLiveData() {
        loginViewModel.getLiveData().observe(
            viewLifecycleOwner,
            { state -> state?.let { handleState(it) } }
        )
    }

    private fun handleState(state: LoginState) {
        when (state) {
            is LoginState.CargandoLoginState -> showLoading()
            is LoginState.UsuarioInvalidoState -> showInvlaidUser()
            is LoginState.LoginExitosoState -> showSuccessLogin()
            is LoginState.ErrorState -> showError()
        }
    }

    private fun showLoading() {
        alert("Cargando")
    }

    private fun showInvlaidUser() {
        alert("Usuario invalido")
    }

    private fun showSuccessLogin() {
        alert("Login exitoso")
    }

    private fun showError() {
        alert("ErrorState")
    }

    private fun setupListeners() {
        binding.apply {
            btnIngresar.setOnClickListener {
                if (validarValoresDelEditText()) {
                    loginViewModel.ingresarUsuario(etEmail.text.toString(), etContrasena.text.toString())
                    Navigation.findNavController(it)
                        .navigate(R.id.action_loginFragment_to_menuFragment)
                }
            }

            btnRegistrar.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }

    private fun validarValoresDelEditText(): Boolean {
        var retorno = true
        binding.apply {
            if (!PassValidator.validate(etContrasena.text.toString())) {
                etContrasena.error = "Contraseña invalida"
                retorno = false
            }

            if (!EmailValidator.validate(etEmail.text.toString())) {
                etEmail.error = "Email invalido"
                retorno = false
            }
        }
        return retorno
    }
}