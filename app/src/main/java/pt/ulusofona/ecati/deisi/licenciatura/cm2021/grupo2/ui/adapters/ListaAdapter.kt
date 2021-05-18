package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.OnClickItemListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste

class ListaAdapter(private val context: Context, private val layout: Int, private val items: MutableList<Teste>, var listener: OnClickItemListener): RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {

    class ListaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val data: TextView = view.text_data
        val resultado: TextView = view.text_resultado
        val imagem: ImageView = view.image_teste

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
        holder.data.text = context.getString(R.string.data) + items[position].data
        holder.resultado.text = context.getString(R.string.resultado) + items[position].resultado
        holder.imagem.setImageResource(item.imagem!!)
        holder.onClickItem(item, listener)
    }
    override fun getItemCount(): Int = items.size
}