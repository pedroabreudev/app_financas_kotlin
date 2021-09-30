package br.com.diastecnologia.financas_kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import br.com.diastecnologia.financas_kotlin.R
import br.com.diastecnologia.financas_kotlin.extension.formataParaBrasileiro
import br.com.diastecnologia.financas_kotlin.extension.limitaEmAte
import br.com.diastecnologia.financas_kotlin.model.Tipo
import br.com.diastecnologia.financas_kotlin.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(
    transacoes: List<Transacao>,
    context: Context
) : BaseAdapter() {

    private val transacoes = transacoes
    private val context = context
    private val limiteDaCategoria = 14


    override fun getCount(): Int {
        return transacoes.size
    }

    override fun getItem(posicao: Int): Transacao {
        return transacoes[posicao]

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewCriada =
            LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]

        if (transacao.tipo == Tipo.RECEITA) {
            viewCriada.transacao_valor
                .setTextColor(ContextCompat.getColor(context, R.color.receita))
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_receita)

        } else {
            viewCriada.transacao_valor
                .setTextColor(ContextCompat.getColor(context, R.color.despesa))
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.icone_transacao_item_despesa)
        }

        var categoriaFormatada = transacao.categoria
        if (categoriaFormatada.length > 14) {
            categoriaFormatada = "${categoriaFormatada.substring(0, 14)}..."
        }

        viewCriada.transacao_valor.text = transacao.valor.formataParaBrasileiro()

        viewCriada.transacao_categoria.text = transacao.categoria.limitaEmAte(limiteDaCategoria)
        viewCriada.transacao_data.text = transacao.data.formataParaBrasileiro()
        return viewCriada
    }


}