package cl.talentodigital.consultavalores.login.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import cl.talentodigital.consultavalores.R
import cl.talentodigital.consultavalores.databinding.FragmentLoginBinding
import cl.talentodigital.consultavalores.login.data.remote.FirebaseLoginRepository
import cl.talentodigital.consultavalores.login.domain.LoginUseCase
import cl.talentodigital.consultavalores.login.domain.model.LoginUsuario
import cl.talentodigital.consultavalores.login.presentation.LoginState
import cl.talentodigital.consultavalores.login.presentation.LoginViewModel
import cl.talentodigital.consultavalores.login.presentation.LoginViewModelFactory
import cl.talentodigital.consultavalores.util.extentions.alert
import cl.talentodigital.consultavalores.util.validator.EmailValidator
import cl.talentodigital.consultavalores.util.validator.PassValidator
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        setupBinding(view)
        setupLiveData()
        setupListeners()
    }

    private fun setupDependencies() {
        viewModelFactory = LoginViewModelFactory(
            LoginUseCase(
                FirebaseLoginRepository(
                    FirebaseAuth.getInstance()
                )
            )
        )

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(LoginViewModel::class.java)
    }

    private fun setupBinding(view: View) {
        binding = FragmentLoginBinding.bind(view)
    }

    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            { state -> state?.let { handleState(it) } }
        )
    }

    private fun handleState(state: LoginState) {
        when (state) {
            is LoginState.LoadingLogin -> showLoading()
            is LoginState.SuccessLogin -> showSuccessLogin()
            is LoginState.InvalidUser -> showInvlaidUser()
            is LoginState.Error -> showError()
        }
    }

    private fun showLoading() {
        alert("Cargando")
    }

    private fun showSuccessLogin() {
        alert("Login exitoso") //Cambio a siguiente fragment por navigation
    }

    private fun showInvlaidUser() {
        alert("Usuario invalido")
    }

    private fun showError() {
        alert("Error")
    }

    private fun setupListeners() {
        binding.apply {
            btnIngresar.setOnClickListener {
                if (validarValoresDelEditText()) {
                    viewModel.ingresarUsuario(etEmail.text.toString(), etContrasena.text.toString())
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