package cl.talentodigital.consultavalores.registro.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.consultavalores.R
import cl.talentodigital.consultavalores.databinding.FragmentRegisterBinding
import cl.talentodigital.consultavalores.registro.data.remote.FirebaseRegistroRepository
import cl.talentodigital.consultavalores.registro.domain.RegistroUseCase
import cl.talentodigital.consultavalores.registro.domain.model.RegistroUsuario
import cl.talentodigital.consultavalores.registro.presentation.RegistroState
import cl.talentodigital.consultavalores.registro.presentation.RegistroViewModel
import cl.talentodigital.consultavalores.registro.presentation.RegistroViewModelFactory
import cl.talentodigital.consultavalores.util.extentions.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegistroViewModel
    private lateinit var viewModelFactory: RegistroViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        setupLiveData()
        setupBind(view)
        setupListeners()
    }

    private fun setupDependencies() {
        viewModelFactory = RegistroViewModelFactory(
            RegistroUseCase(
                FirebaseRegistroRepository(
                    FirebaseAuth.getInstance(),
                    FirebaseDatabase.getInstance()
                )
            )
        )

        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(RegistroViewModel::class.java)
    }

    private fun setupLiveData() {
        viewModel.getLiveData()
            .observe(viewLifecycleOwner,
               { state -> state?.let { handleState(it) } }
            )
    }

    private fun handleState(state: RegistroState) {
        when (state) {
            is RegistroState.LoadingRegistroState -> showLoading()
            is RegistroState.ErrorRegistroState -> showError()
            is RegistroState.EmailAlreadyExist -> repeatedEmail()
            is RegistroState.SuccessRegistroState -> successRegister()
        }
    }

    private fun showLoading() {
        alert("Cargando...")
    }

    private fun showError() {
        alert("Error del servidor")
    }

    private fun repeatedEmail() {
        alert("El email ya esta siendo usado")
    }

    private fun successRegister() {
        alert("Registro exitoso")
    }

    private fun setupBind(view: View) {
        binding = FragmentRegisterBinding.bind(view)
    }

    private fun setupListeners() {
        binding.apply {
            btnRegistrar.setOnClickListener {
                if (validarValoresDelEditText()) {
                    viewModel.registrarUsuario(obtenerValoresDelEditText())
                }
            }

            btnVolver.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun validarValoresDelEditText(): Boolean {
        binding.apply {
            return etConfirmarContrasena.isValidConfirmPassInput(
                "Las contraseñas deben coincidir",
                etContrasena.text.toString()) ||
                    etContrasena.isValidPassInput("Ingrese una contraseña valida") ||
                    etEmail.isValidEmailInput("Ingrese un correo electrónico valido") ||
                    etRut.isValidRutInput("Ingrese un RUN valido") ||
                    etNombre.isValidNameInput("Ingrese un nombre valido")
        }
    }

    private fun obtenerValoresDelEditText(): RegistroUsuario {
        binding.apply {
            return RegistroUsuario(
                etNombre.text.toString(),
                etRut.text.toString(),
                etEmail.text.toString(),
                etContrasena.text.toString()
            )
        }
    }
}
