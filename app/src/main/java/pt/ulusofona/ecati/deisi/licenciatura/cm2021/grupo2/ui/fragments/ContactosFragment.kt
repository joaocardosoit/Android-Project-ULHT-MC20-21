package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_contactos.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.adapters.ExpandableListAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.ContactosViewModel

class ContactosFragment : Fragment() {

    private lateinit var viewModel: ContactosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_contactos, container, false)
        viewModel = ViewModelProviders.of(this).get(ContactosViewModel::class.java)
        return view
    }

    override fun onStart() {
        expandableListView.setAdapter(ExpandableListAdapter(activity as Context, viewModel.assunto, viewModel.conteudo))
        super.onStart()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.mostrarContactos()
    }

}