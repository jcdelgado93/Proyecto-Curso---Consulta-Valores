package cl.talentodigital.consultavalores.detalleMoneda.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.talentodigital.consultavalores.detalleMoneda.domain.ObtenerHistorialUseCase
import cl.talentodigital.consultavalores.detalleMoneda.domain.model.Historial
import kotlinx.coroutines.launch
import java.lang.Exception

class HistorialViewModel(
    private val historialUseCase : ObtenerHistorialUseCase
) : ViewModel() {

    private val liveData = MutableLiveData<HistorialState>()

    fun getLiveData() = liveData

    fun obtenerHistorial(tipoDeMoneda : String, anio : String) {
        liveData.postValue(HistorialState.LoadingListaHistorial)
        viewModelScope.launch {
            try {
                val result = historialUseCase.execute(tipoDeMoneda, anio)
                handleResult(result)
            } catch (exception : Exception) {
                handleError(exception)
            }
        }
    }

    private fun handleResult(result: Historial) {
        liveData.postValue(HistorialState.ObtenerHistorialDeValores(result))
    }

    private fun handleError(exception: Exception) {
        liveData.postValue(HistorialState.Error(exception))
    }
}