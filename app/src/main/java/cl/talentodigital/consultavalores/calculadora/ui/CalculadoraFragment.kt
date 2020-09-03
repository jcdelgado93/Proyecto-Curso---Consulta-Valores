package cl.talentodigital.consultavalores.calculadora.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.talentodigital.consultavalores.R
import cl.talentodigital.consultavalores.databinding.FragmentCalculadoraBinding

class CalculadoraFragment : Fragment(R.layout.fragment_calculadora) {

    private lateinit var binding: FragmentCalculadoraBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBind(view)
    }

    private fun setupBind(view: View) {
        binding = FragmentCalculadoraBinding.bind(view)
    }
}