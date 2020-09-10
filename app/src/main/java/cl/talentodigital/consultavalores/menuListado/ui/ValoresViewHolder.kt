package cl.talentodigital.consultavalores.menuListado.ui

import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.consultavalores.databinding.ItemValoresBinding
import cl.talentodigital.consultavalores.menuListado.domain.model.InfoMoneda

class ValoresViewHolder(
    private val binding : ItemValoresBinding,
    private val listener: ItemListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(moneda : InfoMoneda) {
        binding.apply {
            tvNombreMoneda.text = moneda.nombre
            tvValorMoneda.text = moneda.valor.toString()
            cvItemValores.setOnClickListener{ listener.onItemClick(moneda) }
        }
    }
}