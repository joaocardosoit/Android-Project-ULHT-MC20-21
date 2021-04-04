package pt.ulusofona.deisi.a2020.cm.g2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_adicionar_teste.*
import pt.ulusofona.deisi.a2020.cm.g2.utils.NavigationManager
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.activities.testes
import pt.ulusofona.deisi.a2020.cm.g2.models.Teste

class AdicionarTesteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_adicionar_teste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar_main?.title = "Registe aqui o seu teste"
        activity?.toolbar_main?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        activity?.toolbar_main?.setNavigationOnClickListener{
            activity?.toolbar_main?.title = "MyCovid-19"
            activity?.toolbar_main?.navigationIcon = null
            activity?.supportFragmentManager?.let { NavigationManager.goToListaFragment(it) }
        }

        save_button.setOnClickListener{
            if (resultado.text.toString() != "Positivo" && resultado.text.toString() != "positivo" && resultado.text.toString() != "Negativo" &&
                    resultado.text.toString() != "negativo"){
                resultado.error = "O resultado intruduzido não é valido"
            } else if (local.text.toString() == ""){
                local.error = "Tem de introduzir o local onde foi feito o teste"
            } else if (dateRegister.text.toString() == ""){
                dateRegister.error = "Tem de introduzir o dia em que foi feito o teste"
            } else {
                guardarTeste()
                activity?.toolbar_main?.title = "MyCovid-19"
                activity?.toolbar_main?.navigationIcon = null
                activity?.supportFragmentManager?.let { NavigationManager.goToListaFragment(it) }
            }
        }
    }

    private fun guardarTeste(){
        if(resultado.text.toString() == "Positivo" || resultado.text.toString() == "positivo"){
            val teste = Teste(dateRegister.text.toString(), resultado.text.toString(), true, local.text.toString())
            testes.add(teste)
        } else if (resultado.text.toString() == "Negativo" || resultado.text.toString() == "negativo"){
            val teste = Teste(dateRegister.text.toString(), resultado.text.toString(), false,local.text.toString())
            testes.add(teste)
        }
    }
}