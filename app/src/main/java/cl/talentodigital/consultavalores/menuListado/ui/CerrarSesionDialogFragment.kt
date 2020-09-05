package cl.talentodigital.consultavalores.menuListado.ui

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import cl.talentodigital.consultavalores.R
import cl.talentodigital.consultavalores.databinding.DialogCierreSesionBinding

class CerrarSesionDialogFragment : DialogFragment() {

    private lateinit var binding: DialogCierreSesionBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            binding = DialogCierreSesionBinding.inflate(LayoutInflater.from(context))
            builder.setView(binding.root)
            builder.setPositiveButton("Cerrar Sesión") { _: DialogInterface, _: Int ->
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_cerrarSesionDialogFragment_to_loginFragment)
            }
            builder.setNegativeButton("Volver") { _: DialogInterface, _: Int ->

            }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
