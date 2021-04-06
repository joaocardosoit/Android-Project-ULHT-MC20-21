package pt.ulusofona.deisi.a2020.cm.g2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.utils.NavigationManager

class DetalhesTesteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_destalhes_teste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar_main?.title = "Destalhes do Teste"
        activity?.toolbar_main?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        activity?.toolbar_main?.setNavigationOnClickListener {
            activity?.toolbar_main?.title = "MyCovid-19"
            activity?.toolbar_main?.navigationIcon = null
            activity?.supportFragmentManager?.let { NavigationManager.goToListaFragment(it) }
        }
    }
}