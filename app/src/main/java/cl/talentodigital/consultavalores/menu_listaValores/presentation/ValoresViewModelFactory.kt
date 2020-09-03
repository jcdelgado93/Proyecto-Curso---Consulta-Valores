package cl.talentodigital.consultavalores.menu_listaValores.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.consultavalores.menu_listaValores.domain.ValoresRepository

class ValoresViewModelFactory(
    private val repository: ValoresRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ValoresRepository::class.java)
            .newInstance(repository)
    }
}