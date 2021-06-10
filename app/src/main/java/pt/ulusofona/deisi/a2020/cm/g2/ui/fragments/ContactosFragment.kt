package pt.ulusofona.deisi.a2020.cm.g2.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contactos.*
import pt.ulusofona.deisi.a2020.cm.g2.grupo2.R

import pt.ulusofona.deisi.a2020.cm.g2.ui.adapters.ExpandableListAdapter

class ContactosFragment : Fragment() {

    val assunto: MutableList<String> = mutableListOf()
    val conteudo: MutableList<MutableList<String>> = mutableListOf()
    private val contactosTelefonico: MutableList<String> = ArrayList()
    private val contactosDigitias: MutableList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_contactos, container, false)
        return view
    }

    override fun onStart() {
        expandableListView.setAdapter(ExpandableListAdapter(activity as Context, assunto, conteudo))
        super.onStart()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mostrarContactos()
    }

    fun mostrarContactos(){
        contactosTelefonico.add(getString(R.string.num_telefone_1) + "\n" + getString(R.string.descricao_contactos_1))
        contactosTelefonico.add(getString(R.string.num_telefone_2) + "\n" + getString(R.string.descricao_contactos_2))
        contactosTelefonico.add(getString(R.string.num_telefone_3) + " \n" + getString(R.string.num_telefone_4) + "\n" + getString(
            R.string.descricao_contactos_3))

        contactosDigitias.add(getString(R.string.contacto_digital_1) + "\n" + getString(R.string.descricao_contacto_digital_1))
        contactosDigitias.add(getString(R.string.contacto_digital_2) + "\n" + getString(R.string.descricao_contacto_digital_2))
        contactosDigitias.add(getString(R.string.contacto_digital_3) + "\n" + getString(R.string.descricao_contacto_digital_3))
        contactosDigitias.add(getString(R.string.contacto_digital_4) + "\n" + getString(R.string.descricao_contacto_digital_4))


        assunto.add(getString(R.string.contactos_telefonicos))
        assunto.add(getString(R.string.contactos_digitais))
        conteudo.add(contactosTelefonico)
        conteudo.add(contactosDigitias)

    }

}