package cl.talentodigital.consultavalores.menuListado.ui

import cl.talentodigital.consultavalores.menuListado.domain.model.InfoMoneda

interface ItemListener {
    fun onItemClick(infoMoneda : InfoMoneda)
}