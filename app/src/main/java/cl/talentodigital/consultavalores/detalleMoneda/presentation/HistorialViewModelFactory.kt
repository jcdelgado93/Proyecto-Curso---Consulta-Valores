package cl.talentodigital.consultavalores.detalleMoneda.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.consultavalores.detalleMoneda.domain.ObtenerHistorialUseCase

class HistorialViewModelFactory(
    private val historialUseCase : ObtenerHistorialUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerHistorialUseCase::class.java)
            .newInstance(historialUseCase)
    }
}