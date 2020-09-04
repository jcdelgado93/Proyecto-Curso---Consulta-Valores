package cl.talentodigital.consultavalores.menuListado.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.talentodigital.consultavalores.databinding.ItemValoresBinding
import cl.talentodigital.consultavalores.menuListado.domain.model.Valor

class ValoresAdapter(
    private val valores: List<Valor>
) : RecyclerView.Adapter<ValoresViewHolder>() {

    private lateinit var binding: ItemValoresBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValoresViewHolder {
        binding = ItemValoresBinding.inflate(LayoutInflater.from(parent.context))
        return ValoresViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ValoresViewHolder, position: Int) {
        holder.bind(valores[position])
    }

    override fun getItemCount(): Int {
        return valores.size
    }

}