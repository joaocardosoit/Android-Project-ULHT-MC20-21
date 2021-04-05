package pt.ulusofona.deisi.a2020.cm.g2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_adicionar_teste.*
import pt.ulusofona.deisi.a2020.cm.g2.utils.NavigationManager
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.activities.testes
import pt.ulusofona.deisi.a2020.cm.g2.models.Teste
import java.util.*

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
        val datePicker: DatePicker = date_register
        val hoje = Calendar.getInstance()
        val primeiroDia = Calendar.getInstance()
        primeiroDia.set(2020,0,1)
        datePicker.minDate = primeiroDia.timeInMillis
        datePicker.maxDate = hoje.timeInMillis
        hoje.set(Calendar.YEAR, Calendar.MONTH + 1, Calendar.DAY_OF_MONTH)
        datePicker.init(hoje.get(Calendar.YEAR) + 2020, hoje.get(Calendar.MONTH), hoje.get(Calendar.DAY_OF_MONTH)){
            view, ano, mes, dia ->
            val mes = mes + 1
            val msg = "Você selecionou $dia-$mes-$ano"
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }


        save_button.setOnClickListener{
            if (resultado.text.toString() != "Positivo" && resultado.text.toString() != "positivo" && resultado.text.toString() != "Negativo" &&
                    resultado.text.toString() != "negativo"){
                resultado.error = "O resultado intruduzido não é valido"
            } else if (local.text.toString() == ""){
                local.error = "Tem de introduzir o local onde foi feito o teste"
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
            val teste = Teste(date_register.dayOfMonth.toString() + "/" + date_register.month.toString() +"/" + date_register.year.toString(), resultado.text.toString(), true, local.text.toString())
            testes.add(teste)
        } else if (resultado.text.toString() == "Negativo" || resultado.text.toString() == "negativo"){
            val teste = Teste(date_register.toString(), resultado.text.toString(), false,local.text.toString())
            testes.add(teste)
        }
    }
}