package cl.talentodigital.consultavalores.menuListado.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.consultavalores.menuListado.domain.ValoresRepository
import cl.talentodigital.consultavalores.menuListado.domain.ValoresUseCase

class ValoresViewModelFactory(
    private val useCase: ValoresUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ValoresUseCase::class.java)
            .newInstance(useCase)
    }
}