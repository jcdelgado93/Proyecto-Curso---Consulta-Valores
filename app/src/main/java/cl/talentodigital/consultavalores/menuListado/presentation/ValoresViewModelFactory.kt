package cl.talentodigital.consultavalores.menuListado.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.consultavalores.menuListado.domain.ObtenerValoresUseCase

class ValoresViewModelFactory(
    private val obtenerUseCase: ObtenerValoresUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerValoresUseCase::class.java)
            .newInstance(obtenerUseCase)
    }
}