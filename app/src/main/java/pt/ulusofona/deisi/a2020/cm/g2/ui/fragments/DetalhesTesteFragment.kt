package pt.ulusofona.deisi.a2020.cm.g2.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detalhes_teste.*
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.domain.app.models.Teste
import pt.ulusofona.deisi.a2020.cm.g2.ui.utils.NavigationManager

class DetalhesTesteFragment : Fragment() {

    var teste: Teste? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        teste = arguments?.getParcelable("Teste") as Teste
        return inflater.inflate(R.layout.fragment_detalhes_teste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar_main?.title = getString(R.string.detalhes_teste)
        activity?.toolbar_main?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        activity?.toolbar_main?.setNavigationOnClickListener {
            activity?.toolbar_main?.title = getString(R.string.titulo)
            activity?.toolbar_main?.navigationIcon = null
            activity?.supportFragmentManager?.let { NavigationManager.goToListaFragment(it) }
        }
    }

    override fun onStart() {
        super.onStart()
        detalhesTeste(teste)
    }

    @SuppressLint("SetTextI18n")
    private fun detalhesTeste(teste: Teste?){
        teste?.let {
            image_descricao.setImageResource(teste.imagem!!)
            texta_local_descricao.text = getString(R.string.teste_realizado_em) + teste.local
            texta_data_descricao.text = getString(R.string.teste_feito_a) + teste.data
            texta_resultado_descricao.text = getString(R.string.o_resultado_do_teste_foi) + teste.resultado
        }
    }
}