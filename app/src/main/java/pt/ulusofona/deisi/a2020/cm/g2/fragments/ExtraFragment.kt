package pt.ulusofona.deisi.a2020.cm.g2.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_extra.*
import kotlinx.android.synthetic.main.fragment_lista.*
import kotlinx.android.synthetic.main.item_lista_concelhos.*
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.activities.listaConcelhos
import pt.ulusofona.deisi.a2020.cm.g2.adapters.ExtraAdapter
import kotlin.random.Random


class ExtraFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_extra, container, false)
    }

    override fun onStart() {
        super.onStart()
        list_casos_concelho.layoutManager = LinearLayoutManager(activity as Context)
        list_casos_concelho.adapter = ExtraAdapter(activity as Context, R.layout.item_lista_concelhos, listaConcelhos)
    }

}