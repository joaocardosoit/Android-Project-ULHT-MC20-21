package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_adicionar_teste.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities.MainActivity
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils.NavigationManager

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.TesteViewModel
import java.util.*
import java.util.jar.Manifest

class AdicionarTesteFragment : Fragment() {

    var image_uri: Uri?=null
    var IMAGE_CAPTURE_CODE=101
    var PERMISSION_CODE=100
    private val CAMERA_PERMISSION_CODE = 0

    private lateinit var viewModel: TesteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_adicionar_teste, container, false)
        viewModel = ViewModelProviders.of(this).get(TesteViewModel::class.java)
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

        foto_button.setOnClickListener {
            if (ContextCompat.checkSelfPermission(context!!, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_PERMISSION_CODE)
            } else {
                Toast.makeText(context, "A premissão para abrir a câmera foi negada", Toast.LENGTH_LONG).show()
            }
        }

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

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, CAMERA_PERMISSION_CODE)
            } else {
                Toast.makeText(context, "A premissão para abrir a câmera foi negada", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == CAMERA_PERMISSION_CODE){
                val image: Bitmap = data?.extras?.get("data") as Bitmap
                image_add.setImageBitmap(image)
            }
        }
    }
}