package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista_concelhos.view.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Concelhos

class ExtraAdapter(private val context: Context, private val layout: Int, private val items: MutableList<Concelhos>): RecyclerView.Adapter<ExtraAdapter.ExtraListaViewHolder>()  {
    val red = Color.rgb(255, 0, 0)
    val green = Color.rgb(0, 255, 0)
    val yellow = Color.rgb(253, 203, 0)

    class ExtraListaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nomeConcelho: TextView = view.concelhos
        val numCasosAtivos: TextView = view.casos_ativos
        val numMortos: TextView = view.mortos
        val numRecuperados: TextView = view.recuperados
        val cardView: CardView = view.cardview_extra
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtraListaViewHolder {
        return ExtraListaViewHolder(LayoutInflater.from(context).inflate(layout, parent, false))
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ExtraListaViewHolder, position: Int) {
        val item = items[position]
        /*
        holder.nomeConcelho.text = items[position].nome
        holder.numCasosAtivos.text = context.getString(R.string.casos_ativos) + items[position].casosAtivos.toString()
        holder.numMortos.text = context.getString(R.string.mortos) + items[position].mortos.toString()
        holder.numRecuperados.text = context.getString(R.string.recuperados) + items[position].recuperados.toString()

        for (i in 0..items.size - 1){
            if (item.casosAtivos >= 0 && item.casosAtivos <= 100){
                holder.cardView.setCardBackgroundColor(green)
            } else if(item.casosAtivos > 100 && item.casosAtivos <= 250) {
                holder.cardView.setCardBackgroundColor(yellow)
            } else {
                holder.cardView.setCardBackgroundColor(red)
            }
        }*/
    }
}