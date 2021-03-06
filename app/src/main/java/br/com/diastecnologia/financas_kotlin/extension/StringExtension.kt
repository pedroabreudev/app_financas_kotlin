package br.com.diastecnologia.financas_kotlin.extension

fun String.limitaEmAte(caracteres: Int) : String{
    if(this.length > caracteres){
        val primeiroCaracter = 0
        return "${this.substring(primeiroCaracter, caracteres)}..."
    }
    return this
}