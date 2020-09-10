package cl.talentodigital.consultavalores.menuListado.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.talentodigital.consultavalores.menuListado.domain.ObtenerValoresUseCase
import cl.talentodigital.consultavalores.menuListado.domain.model.Monedas
import kotlinx.coroutines.launch
import java.lang.Exception

class ValoresViewModel(
    private val useCaseObtener: ObtenerValoresUseCase
) : ViewModel() {

    private val liveData = MutableLiveData<ValoresState>()

    fun getLiveData() = liveData

    fun obtenerMonedas() {
        liveData.postValue(ValoresState.LoadingListaValores)
        viewModelScope.launch {
            try {
                val result = useCaseObtener.execute()
                handleResult(result)
            } catch (exception: Exception) {
                handlerError(exception)
            }
        }
    }

    private fun handleResult(result: Monedas) {
        liveData.postValue(ValoresState.ObtencionDeValores(result))
    }

    private fun handlerError(exception: Exception) {
        liveData.postValue(ValoresState.Error(exception))
    }
}