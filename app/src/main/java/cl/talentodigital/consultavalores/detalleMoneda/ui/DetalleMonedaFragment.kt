package cl.talentodigital.consultavalores.detalleMoneda.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.consultavalores.R
import cl.talentodigital.consultavalores.databinding.FragmentDetalleMonedaBinding
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

class DetalleMonedaFragment : Fragment(R.layout.fragment_detalle_moneda) {

    private lateinit var binding: FragmentDetalleMonedaBinding
    private lateinit var adapter: DetalleAdapter
    private lateinit var viewModel: ValoresViewModel
    private lateinit var viewModelFactory: ValoresViewModelFactory

    companion object{
        const val CODIGO = "codigo"
        const val NOMBRE = "nombre"
        const val UNIDAD_DE_MEDIDA = "unidad de medida"
        const val FECHA = "fecha"
        const val VALOR = "valor"

        fun infoMonedaBundle(infoMoneda: InfoMoneda) : Bundle {
            val bundle = Bundle()
            bundle.putString(CODIGO, infoMoneda.codigo)
            bundle.putString(NOMBRE, infoMoneda.nombre)
            bundle.putString(UNIDAD_DE_MEDIDA, infoMoneda.unidadMedida)
            bundle.putString(FECHA, infoMoneda.fecha)
            bundle.putFloat(VALOR, infoMoneda.valor?: 0.0f)
            return bundle
        }

        fun infoMonedaBundle(bundle: Bundle) : InfoMoneda {
            val codigo = bundle.getString(CODIGO)
            val nombre = bundle.getString(NOMBRE)
            val unidadDeMedida = bundle.getString(UNIDAD_DE_MEDIDA)
            val fecha = bundle.getString(FECHA)
            val valor = bundle.getFloat(VALOR)
            return InfoMoneda(codigo, nombre, unidadDeMedida, fecha, valor)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBind(view)
        arguments?.let { safeBundle -> cargarMoneda(infoMonedaBundle(safeBundle)) }
        setupDependencies()
        setupLiveData()
    }

    private fun setupBind(view: View) {
        binding = FragmentDetalleMonedaBinding.bind(view)
    }

    private fun cargarMoneda(infoMonedaBundle: InfoMoneda) {
        binding.apply {
            tvCodigo.text = infoMonedaBundle.codigo
            tvNombre.text = infoMonedaBundle.nombre
            tvUnidadMedida.text = infoMonedaBundle.unidadMedida
            tvValor.text = infoMonedaBundle.valor.toString()
            tvNombreMoneda.text = infoMonedaBundle.nombre
        }
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

    private fun mostrarValores(it: Monedas) {
        adapter = DetalleAdapter(it.listadoDeMonedas)
        binding.rvHistorialValores.adapter = adapter
    }

    private fun mostrarError(error: Throwable) {
        alert("Error: ${error.message}")
    }
}