package pt.ulusofona.deisi.a2020.cm.g2.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*
import pt.ulusofona.deisi.a2020.cm.g2.listeners.OnClickItemListener
import pt.ulusofona.deisi.a2020.cm.g2.models.Teste
import pt.ulusofona.deisi.a2020.cm.g2.utils.NavigationManager

class ListaAdapter(private val context: Context, private val layout: Int, private val items: MutableList<Teste>, var listener: OnClickItemListener): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {

    class ListaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val data: TextView = view.text_data
        val resultado: TextView = view.text_resultado

        fun onClickItem(teste: Teste, listener: OnClickItemListener){
            itemView.setOnClickListener {
                listener.onClickItem(teste)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        return ListaViewHolder(LayoutInflater.from(context).inflate(layout, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val item = items[position]
        holder.data.text = "Data: ${items[position].data}"
        holder.resultado.text = "Resultado: ${items[position].resultado}"
        holder.onClickItem(item, listener)
    }

    override fun getItemCount(): Int = items.size
}