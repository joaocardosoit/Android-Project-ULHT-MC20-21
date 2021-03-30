package pt.ulusofona.deisi.a2020.cm.g2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*

class ListaAdapter(private val context: Context, private val layout: Int, private val items: MutableList<Teste>): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {

    class ListaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val numCasos: TextView = view.text_numCasos
        val cidade: TextView = view.text_cidade
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        return ListaViewHolder(LayoutInflater.from(context).inflate(layout, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        holder.cidade.text = "Cidade: ${items[position].cidade}"
        holder.numCasos.text = "Nº de Casos: ${items[position].numCasos}"
    }

    override fun getItemCount(): Int = items.size
}