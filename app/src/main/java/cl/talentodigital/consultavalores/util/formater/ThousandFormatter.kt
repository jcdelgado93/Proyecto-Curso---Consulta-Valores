package cl.talentodigital.consultavalores.util.formater

import cl.talentodigital.consultavalores.util.ConstantValues.EMPTY_STRING
import cl.talentodigital.consultavalores.util.ConstantValues.POINT_VALUE
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

object ThousandFormatter {

    private const val LANGUAGE = "es"
    private const val COUNTRY = "CL"
    private const val PATTERN = "#,###"

    fun format(input: String): String {
        val number = input.replace(POINT_VALUE, EMPTY_STRING)
        val df = DecimalFormat(PATTERN, DecimalFormatSymbols(Locale(LANGUAGE, COUNTRY)))
        return df.format(number.toLong())
    }
}