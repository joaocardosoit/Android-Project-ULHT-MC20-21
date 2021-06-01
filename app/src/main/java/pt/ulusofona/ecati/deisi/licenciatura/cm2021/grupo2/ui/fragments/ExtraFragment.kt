package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_extra.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Concelhos
//import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities.listaConcelhos
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.adapters.ExtraAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ConcelhosListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.ConcelhosViewModel


class ExtraFragment : Fragment(), ConcelhosListener {

    lateinit var viewModel: ConcelhosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_extra, container, false)
        viewModel = ViewModelProviders.of(this).get(ConcelhosViewModel::class.java)
        return view
    }

    override fun onStart() {
        super.onStart()
        context?.let { viewModel.registerListener(this, it) }

    }

    override fun concelhos(listaConcelhos: List<Concelhos>) {
        listaConcelhos.let {
            list_casos_concelho.layoutManager = LinearLayoutManager(activity as Context)
            list_casos_concelho.adapter = ExtraAdapter(activity as Context, R.layout.item_lista_concelhos, listaConcelhos.toMutableList() as ArrayList<Concelhos>)
        }
    }

}