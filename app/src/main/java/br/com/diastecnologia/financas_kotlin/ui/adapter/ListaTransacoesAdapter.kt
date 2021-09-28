package br.com.diastecnologia.financas_kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.diastecnologia.financas_kotlin.R
import br.com.diastecnologia.financas_kotlin.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*
import java.text.SimpleDateFormat

class ListaTransacoesAdapter(
    transacoes: List<Transacao>,
    context: Context) : BaseAdapter(){

    private val transacoes = transacoes
    private val context = context


    override fun getCount(): Int {
        return transacoes.size
    }

    override fun getItem(posicao: Int): Transacao {
        return transacoes[posicao]

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?) : View {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]

        viewCriada.transacao_valor.text = transacao.valor.toString()
        viewCriada.transacao_categoria.text = transacao.categoria

        val formatoBrasileiro = "dd/MM/yyyy"
        val formatter = SimpleDateFormat(formatoBrasileiro)
        val dataFormatada = formatter.format(transacao.data.time)
        viewCriada.transacao_data.text = dataFormatada

        //viewCriada.transacao_icone.setImageResource()

        return viewCriada
    }
}