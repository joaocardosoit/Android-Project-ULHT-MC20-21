package pt.ulusofona.deisi.a2020.cm.g2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contactos.*

class ContactosFragment : Fragment() {

    private val assunto: MutableList<String> = mutableListOf()
    private val conteudo: MutableList<MutableList<String>> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contactos, container, false)
    }

    override fun onStart() {

        expandableListView.setAdapter(pt.ulusofona.deisi.a2020.cm.g2.ExpandableListAdapter(activity as Context, assunto, conteudo))
        super.onStart()
    }
}