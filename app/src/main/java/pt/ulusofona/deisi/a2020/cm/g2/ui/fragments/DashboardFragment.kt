package pt.ulusofona.deisi.a2020.cm.g2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dashboard.*
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.ui.activities.numerosCovid
import pt.ulusofona.deisi.a2020.cm.g2.domain.app.models.NumsCovid

class DashboardFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mostrarNumeros(numerosCovid, numerosCovid.size-1)
    }

    private fun mostrarNumeros(lista: MutableList<NumsCovid>, position: Int){
        num_infetados.text = lista[position].numInfetados.toString()
        num_mortes.text = lista[position].numMortes.toString()
        num_recuperados.text = lista[position].numRecuperados.toString()
        num_total_infetados.text = lista[position].numTotalCasos.toString()
        num_total_mortes.text = lista[position].numTotalMortes.toString()
        num_total_recuperados.text = lista[position].numTotalRecuperados.toString()
    }
}