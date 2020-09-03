package cl.talentodigital.consultavalores.menu_listaValores.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.talentodigital.consultavalores.menu_listaValores.domain.ValoresRepository
import cl.talentodigital.consultavalores.menu_listaValores.domain.model.Valores
import kotlinx.coroutines.launch
import java.lang.Exception

class ValoresViewModel(
    private val repository: ValoresRepository
) : ViewModel() {

    private val liveData = MutableLiveData<ValoresState>()

    fun getLiveData() = liveData

    fun obtenerValores() {
        liveData.postValue(ValoresState.LoadingListaValores)
        viewModelScope.launch {
            try {
                val result = repository.obtenerValores()
                handleResult(result)
            } catch (exception: Exception) {
                handlerError(exception)
            }
        }
    }

    private fun handleResult(result: Valores) {
        liveData.postValue(ValoresState.ObtencionDeValores(result))
    }

    private fun handlerError(exception: Exception) {
        liveData.postValue(ValoresState.Error(exception))
    }
}