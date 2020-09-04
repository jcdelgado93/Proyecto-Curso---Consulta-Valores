package cl.talentodigital.consultavalores.menuListado.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.talentodigital.consultavalores.R
import cl.talentodigital.consultavalores.databinding.FragmentMenuBinding
import cl.talentodigital.consultavalores.menuListado.data.remote.Mapper
import cl.talentodigital.consultavalores.menuListado.data.remote.RemoteValoresRepository
import cl.talentodigital.consultavalores.menuListado.domain.ValoresUseCase
import cl.talentodigital.consultavalores.menuListado.domain.model.Valores
import cl.talentodigital.consultavalores.menuListado.presentation.ValoresState
import cl.talentodigital.consultavalores.menuListado.presentation.ValoresViewModel
import cl.talentodigital.consultavalores.menuListado.presentation.ValoresViewModelFactory
import cl.talentodigital.consultavalores.network.api.RetrofitHandler

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var adapter: ValoresAdapter
    private lateinit var viewModel: ValoresViewModel
    private lateinit var viewModelFactory: ValoresViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBind(view)
        setupDependencies()
        setupLiveData()
        setupRecyclerView()
        obtenerViewModel()
    }

    private fun setupBind(view: View) {
        binding = FragmentMenuBinding.bind(view)
    }

    private fun setupDependencies() {
        viewModelFactory = ValoresViewModelFactory(
            ValoresUseCase(
                RemoteValoresRepository(
                    RetrofitHandler.getValoresApi(),
                    Mapper()
                )
            )
        )

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ValoresViewModel::class.java)
    }

    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            { state -> handleState(state) }
        )

        viewModel.obtenerValores()
    }

    private fun handleState(state: ValoresState?) {
        when (state) {
            is ValoresState.LoadingListaValores -> mostrarCargando()
            is ValoresState.ObtencionDeValores -> state.result?.let { mostrarValores(it) }
            is ValoresState.Error -> state.error?.let { mostrarError(it) }
        }
    }

    private fun mostrarCargando() {
        Toast.makeText(requireContext(), "Cargando valores.", Toast.LENGTH_SHORT).show()
    }

    private fun mostrarValores(it: Valores) {
        adapter = ValoresAdapter(it.listaValores)
        binding.rvListaValores.adapter = adapter
    }

    private fun mostrarError(it: Throwable) {
        Toast.makeText(requireContext(), "Error: {${it.message}", Toast.LENGTH_SHORT).show()
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvListaValores.setHasFixedSize(true)
            rvListaValores.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun obtenerViewModel() {
        viewModel.obtenerValores()
    }
}