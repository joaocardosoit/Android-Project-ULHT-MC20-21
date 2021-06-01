package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_dashboard.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.DadosCovid
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.DadosCovidListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.DadosCovidViewModel

class DashboardFragment : Fragment(), DadosCovidListener {

    lateinit var viewModel: DadosCovidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        context?.let { viewModel.registerListener(this, it) }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        viewModel = ViewModelProviders.of(this).get(DadosCovidViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun dadosCovid(dadosCovid: DadosCovid?) {
        num_infetados.text = dadosCovid?.confirmadosNovos.toString()
        num_internados.text = dadosCovid?.internados.toString()
        num_internados_uci.text = dadosCovid?.internadosUci.toString()
        num_total_mortes.text = dadosCovid?.obitos.toString()
        num_total_infetados.text = dadosCovid?.confirmados.toString()
        num_total_recuperados.text = dadosCovid?.recuperados.toString()
    }

}