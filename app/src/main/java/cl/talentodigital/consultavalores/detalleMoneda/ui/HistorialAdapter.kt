package cl.talentodigital.consultavalores.detalleMoneda.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.consultavalores.databinding.ItemHistorialBinding
import cl.talentodigital.consultavalores.detalleMoneda.domain.model.InfoHistorial

class HistorialAdapter(
    private val listaHistorial: List<InfoHistorial>
) : RecyclerView.Adapter<HistorialViewHolder>() {

    private lateinit var binding: ItemHistorialBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistorialViewHolder {
        binding = ItemHistorialBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return HistorialViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistorialViewHolder, position: Int) {
        holder.bind(listaHistorial[position])
    }

    override fun getItemCount(): Int {
        return listaHistorial.size
    }
}