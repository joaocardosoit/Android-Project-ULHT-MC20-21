package pt.ulusofona.deisi.a2020.cm.g2.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_extra.*
import kotlinx.android.synthetic.main.fragment_lista.*
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.activities.concelhos
import pt.ulusofona.deisi.a2020.cm.g2.activities.testes
import pt.ulusofona.deisi.a2020.cm.g2.adapters.ExtraAdapter
import pt.ulusofona.deisi.a2020.cm.g2.adapters.ListaAdapter
import pt.ulusofona.deisi.a2020.cm.g2.utils.NavigationManager
import kotlin.random.Random


class ExtraFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_extra, container, false)
    }

    override fun onStart() {
        super.onStart()
        list_casos_concelho.layoutManager = LinearLayoutManager(activity as Context)
        list_casos_concelho.adapter = ExtraAdapter(activity as Context, R.layout.item_lista_concelhos, concelhos)
    }

}