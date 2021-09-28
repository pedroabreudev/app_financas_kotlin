package br.com.diastecnologia.financas_kotlin.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.diastecnologia.financas_kotlin.R
import br.com.diastecnologia.financas_kotlin.model.Transacao
import br.com.diastecnologia.financas_kotlin.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Transacao(BigDecimal(20.5), "Comida", Calendar.getInstance()), Transacao(
            BigDecimal(100.0),"Economia", Calendar.getInstance()))

        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes, this))

    }
}