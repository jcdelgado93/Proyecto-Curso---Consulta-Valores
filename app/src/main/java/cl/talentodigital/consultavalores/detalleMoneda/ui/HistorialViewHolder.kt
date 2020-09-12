package cl.talentodigital.consultavalores.detalleMoneda.ui

import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.consultavalores.databinding.ItemHistorialBinding
import cl.talentodigital.consultavalores.detalleMoneda.domain.model.InfoHistorial

class HistorialViewHolder(
    private val binding: ItemHistorialBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(infoHistorial: InfoHistorial) {
        binding.apply {
            tvFecha.text = infoHistorial.fecha
            tvValorMoneda.text = infoHistorial.valor.toString()
        }
    }

}