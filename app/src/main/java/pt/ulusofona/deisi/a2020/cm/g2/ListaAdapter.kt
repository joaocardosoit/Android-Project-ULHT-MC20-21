package pt.ulusofona.deisi.a2020.cm.g2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*

class ListaAdapter(private val context: Context, private val layout: Int, private val items: MutableList<Teste>): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {

    class ListaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val resultado: TextView = view.text_resultado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        return ListaViewHolder(LayoutInflater.from(context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        holder.resultado.text = items[position].resultado
    }

    override fun getItemCount(): Int = items.size
}