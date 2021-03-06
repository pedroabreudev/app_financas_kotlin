package br.com.diastecnologia.financas_kotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.diastecnologia.financas_kotlin.R
import br.com.diastecnologia.financas_kotlin.model.Tipo
import br.com.diastecnologia.financas_kotlin.model.Transacao
import br.com.diastecnologia.financas_kotlin.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes : List<Transacao> = transacoesDeExemplo()

        configuraLista(transacoes)

    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo() = listOf(
        Transacao(valor = BigDecimal(20.5), tipo = Tipo.DESPESA),
        Transacao(valor = BigDecimal(100.0), categoria = "Economia", tipo = Tipo.RECEITA),
        Transacao(valor = BigDecimal(200.0), tipo = Tipo.DESPESA),
        Transacao(valor = BigDecimal(500.0), categoria = "Prêmio", tipo = Tipo.RECEITA)
    )
}