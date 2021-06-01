package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_estou_perigo.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Concelhos
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ConcelhosListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.ConcelhosViewModel

class EstouPerigoFragment : Fragment(), ConcelhosListener {

    lateinit var viewModel: ConcelhosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_estou_perigo, container, false)
        viewModel = ViewModelProviders.of(this).get(ConcelhosViewModel::class.java)
        return view
    }

    override fun listaConcelhos(listaConcelhos: List<Concelhos>) {
    }
}