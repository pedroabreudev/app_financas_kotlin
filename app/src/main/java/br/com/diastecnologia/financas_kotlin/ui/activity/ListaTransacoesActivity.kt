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

        val transacoes = listOf(Transacao( valor = BigDecimal(20.5), tipo = Tipo.DESPESA),
            Transacao(valor = BigDecimal(100.0), categoria = "Economia", tipo = Tipo.RECEITA))

        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes, this))

    }
}