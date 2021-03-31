package pt.ulusofona.deisi.a2020.cm.g2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_lista.*

class ListaFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onStart() {
        super.onStart()
        list_casos.layoutManager = LinearLayoutManager(activity as Context)
        list_casos.adapter = ListaAdapter(activity as Context, R.layout.item_lista, testes)
    }
}