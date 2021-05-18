package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_adicionar_teste.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils.NavigationManager

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.AdicinarTesteViewModel
import java.util.*

class AdicionarTesteFragment : Fragment() {

    var image_uri: Uri?=null
    var IMAGE_CAPTURE_CODE=101
    var PERMISSION_CODE=100

    private lateinit var viewModel: AdicinarTesteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adicionar_teste, container, false)
        viewModel = ViewModelProviders.of(this).get(AdicinarTesteViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar_main?.title = getString(R.string.adicionar_teste_titulo)
        activity?.toolbar_main?.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        activity?.toolbar_main?.setNavigationOnClickListener{
            activity?.toolbar_main?.title = getString(R.string.titulo)
            activity?.toolbar_main?.navigationIcon = null
            activity?.supportFragmentManager?.let { NavigationManager.goToListaFragment(it) }
        }
        val datePicker: DatePicker = date_register
        val hoje = Calendar.getInstance()
        datePicker.init(hoje.get(Calendar.YEAR) + 2020, hoje.get(Calendar.MONTH), hoje.get(Calendar.DAY_OF_MONTH)){
            viewCalendario, ano, mes, dia ->
            val mesAtual = mes + 1
            val msg = getString(R.string.selecionou) + "$dia-$mesAtual-$ano"
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
        datePicker.maxDate = hoje.timeInMillis

        save_button.setOnClickListener{
            if (resultado.text.toString() != "Positivo" && resultado.text.toString() != "positivo" && resultado.text.toString() != "Negativo" &&
                    resultado.text.toString() != "negativo"){
                resultado.error = getString(R.string.mensagem_erro_1)
                Toast.makeText(context, getString(R.string.mensagem_erro_1), Toast.LENGTH_SHORT).show()
            } else if (local.text.toString() == ""){
                local.error = getString(R.string.mensagem_erro_2)
                Toast.makeText(context, getString(R.string.mensagem_erro_2), Toast.LENGTH_SHORT).show()
            } else {
                val mes = date_register.month + 1
                val teste = Teste(R.drawable.no_foto, date_register.dayOfMonth.toString() + "/" + mes.toString() + "/" + date_register.year.toString() , resultado.text.toString(), true,  local.text.toString())
                viewModel.insert(teste)
                activity?.toolbar_main?.title = getString(R.string.titulo)
                activity?.toolbar_main?.navigationIcon = null
                activity?.supportFragmentManager?.let { NavigationManager.goToListaFragment(it) }
            }
        }
    }
}