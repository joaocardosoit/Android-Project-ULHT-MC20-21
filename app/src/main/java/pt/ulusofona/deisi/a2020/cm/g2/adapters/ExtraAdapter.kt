package pt.ulusofona.deisi.a2020.cm.g2.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*
import kotlinx.android.synthetic.main.item_lista_concelhos.view.*
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.listeners.OnClickItemListener
import pt.ulusofona.deisi.a2020.cm.g2.models.Concelhos
import pt.ulusofona.deisi.a2020.cm.g2.models.Teste

class ExtraAdapter(private val context: Context, private val layout: Int, private val items: MutableList<Concelhos>): RecyclerView.Adapter<ExtraAdapter.ExtraListaViewHolder>()  {

    class ExtraListaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nomeConcelho: TextView = view.concelhos
        val numCasosAtivos: TextView = view.casos_ativos
        val numMortos: TextView = view.mortos
        val numRecuperados: TextView = view.recuperados

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraListaViewHolder {
        return ExtraListaViewHolder(LayoutInflater.from(context).inflate(layout, parent, false))
    }



    override fun getItemCount(): Int = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ExtraListaViewHolder, position: Int) {
        val item = items[position]
        holder.nomeConcelho.text = items[position].nome
        holder.numCasosAtivos.text = context.getString(R.string.casos_ativos) + items[position].casosAtivos.toString()
        holder.numMortos.text = context.getString(R.string.mortos) + items[position].mortos.toString()
        holder.numRecuperados.text = context.getString(R.string.recuperados) + items[position].recuperados.toString()
    }
}