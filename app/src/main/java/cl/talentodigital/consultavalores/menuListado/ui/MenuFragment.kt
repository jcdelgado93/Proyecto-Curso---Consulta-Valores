package cl.talentodigital.consultavalores.menuListado.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import cl.talentodigital.consultavalores.R
import cl.talentodigital.consultavalores.databinding.FragmentMenuBinding
import cl.talentodigital.consultavalores.detalleMoneda.ui.DetalleMonedaFragment
import cl.talentodigital.consultavalores.menuListado.data.remote.ValoresMapper
import cl.talentodigital.consultavalores.menuListado.data.remote.RemoteValoresRepository
import cl.talentodigital.consultavalores.menuListado.domain.ObtenerValoresUseCase
import cl.talentodigital.consultavalores.menuListado.domain.model.InfoMoneda
import cl.talentodigital.consultavalores.menuListado.domain.model.Monedas
import cl.talentodigital.consultavalores.menuListado.presentation.ValoresState
import cl.talentodigital.consultavalores.menuListado.presentation.ValoresViewModel
import cl.talentodigital.consultavalores.menuListado.presentation.ValoresViewModelFactory
import cl.talentodigital.consultavalores.network.api.RetrofitHandler
import cl.talentodigital.consultavalores.util.extentions.alert

class MenuFragment: Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var dialog: CerrarSesionDialogFragment
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater: MenuInflater? = activity?.menuInflater
        inflater?.inflate(R.menu.menu_actions, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_actualizar -> {
                actualizar()
                true
            }
            R.id.action_cerrar_sesion -> {
                mostrarDialogoDeConfirmacion()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun actualizar() {

    }

    private fun mostrarDialogoDeConfirmacion() {
        activity?.supportFragmentManager?.let { dialog.show(it, "String") }
    }

    private fun setupBind(view: View) {
        binding = FragmentMenuBinding.bind(view)
    }

    private fun setupDependencies() {
        viewModelFactory = ValoresViewModelFactory(
            ObtenerValoresUseCase(
                RemoteValoresRepository(
                    RetrofitHandler.getValoresApi(),
                    ValoresMapper()
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

        viewModel.obtenerMonedas()
    }

    private fun handleState(state: ValoresState?) {
        when (state) {
            is ValoresState.LoadingListaValores -> mostrarCargando()
            is ValoresState.ObtencionDeValores -> state.result?.let { mostrarValores(it) }
            is ValoresState.Error -> state.error?.let { mostrarError(it) }
        }
    }

    private fun mostrarCargando() {
        alert("Cargando valores.")
    }

    private fun mostrarValores(monedas: Monedas) {
        adapter = ValoresAdapter(monedas.listadoDeMonedas, object : ItemListener {
            override fun onItemClick(infoMoneda: InfoMoneda) {
                view?.let { safeView -> Navigation.findNavController(safeView)
                    .navigate(R.id.action_menuFragment_to_detalleMonedaFragment, DetalleMonedaFragment.infoMonedaBundle(infoMoneda)) }
            }
        })
        binding.rvListaValores.adapter = adapter
    }

    private fun mostrarError(error: Throwable) {
        alert("Error: ${error.message}")
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvListaValores.setHasFixedSize(true)
            rvListaValores.layoutManager = LinearLayoutManager(requireContext())
            rvListaValores.itemAnimator = DefaultItemAnimator()
        }
    }

    private fun obtenerViewModel() {
        viewModel.obtenerMonedas()
    }
}