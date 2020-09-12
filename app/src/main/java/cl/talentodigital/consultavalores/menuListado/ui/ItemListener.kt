package cl.talentodigital.consultavalores.menuListado.ui

import cl.talentodigital.consultavalores.menuListado.domain.model.DetalleValores

interface ItemListener {
    fun onItemClick(detalleValores : DetalleValores)
}