package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_extra.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
//import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities.listaConcelhos
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.adapters.ExtraAdapter


class ExtraFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_extra, container, false)
    }

    override fun onStart() {
        super.onStart()
        list_casos_concelho.layoutManager = LinearLayoutManager(activity as Context)
        //ist_casos_concelho.adapter = ExtraAdapter(activity as Context, R.layout.item_lista_concelhos, listaConcelhos)
    }

}