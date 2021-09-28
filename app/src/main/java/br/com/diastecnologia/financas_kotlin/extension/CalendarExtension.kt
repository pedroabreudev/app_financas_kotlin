package br.com.diastecnologia.financas_kotlin.extension

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formataParaBrasileiro() : String {
    val formatoBrasileiro = "dd/MM/yyyy"
    val formatter = SimpleDateFormat(formatoBrasileiro)
    return formatter.format(this.time)

}