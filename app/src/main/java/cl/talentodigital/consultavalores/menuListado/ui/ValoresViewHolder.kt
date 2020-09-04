package cl.talentodigital.consultavalores.menuListado.ui

import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.consultavalores.databinding.ItemValoresBinding
import cl.talentodigital.consultavalores.menuListado.domain.model.Valor

class ValoresViewHolder(
    private val binding : ItemValoresBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(valor : Valor) {
        binding.apply {
            tvNombreMoneda.text = valor.nombre
            tvValorMoneda.text = valor.valor.toString()
        }
    }
}