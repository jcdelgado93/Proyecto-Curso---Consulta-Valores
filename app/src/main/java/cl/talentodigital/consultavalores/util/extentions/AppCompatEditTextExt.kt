package cl.talentodigital.consultavalores.util.extentions

import androidx.appcompat.widget.AppCompatEditText
import cl.talentodigital.consultavalores.util.validator.EmailValidator
import cl.talentodigital.consultavalores.util.validator.NameValidator
import cl.talentodigital.consultavalores.util.validator.PassValidator
import cl.talentodigital.consultavalores.util.validator.RutValidator

fun AppCompatEditText.isValidNameInput(message: String) : Boolean{
    val result = NameValidator.validate(text.toString())
    if(!result){
        this.error = message
        requestFocus()
    }
    return result
}

fun AppCompatEditText.isValidRutInput(message: String) : Boolean{
    val result = RutValidator.validate(text.toString())
    if(!result){
        error = message
        requestFocus()
    }
    return result
}

fun AppCompatEditText.isValidEmailInput(message: String) : Boolean{
    val result = EmailValidator.validate(text.toString())
    if(!result){
        error = message
        requestFocus()
    }
    return result
}

fun AppCompatEditText.isValidPassInput(message: String) : Boolean{
    val result = PassValidator.validate(text.toString())
    if(!result){
        error = message
        requestFocus()
    }
    return result
}

fun AppCompatEditText.isValidConfirmPassInput(message: String, pass: String) : Boolean {
    val result = pass == text.toString()
    if(!result){
        error = message
        requestFocus()
    }
    return result
}