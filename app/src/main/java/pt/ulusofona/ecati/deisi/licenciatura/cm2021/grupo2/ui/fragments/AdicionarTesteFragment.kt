package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.lifecycle.ViewModelProviders
import butterknife.ButterKnife
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
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                if(PermissionChecker.checkSelfPermission(
                        activity as Context,
                        android.Manifest.permission.CAMERA
                    ) == PermissionChecker.PERMISSION_DENIED || PermissionChecker.checkSelfPermission(
                        activity as Context,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) == PermissionChecker.PERMISSION_DENIED){
                    requestPermissions(arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        PERMISSION_CODE)
                }else{
                    openCamera()
                }
            }else{
                openCamera()
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

    override fun onStart() {
        val sharedPreferences= PreferenceManager.getDefaultSharedPreferences(activity as Context)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()
        editor.putBoolean("otherFragment",true)
        editor.apply()
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListener()
        super.onDestroy()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    openCamera()
                }
                return
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==IMAGE_CAPTURE_CODE){
            if(resultCode== Activity.RESULT_OK){
                getImage().setImageURI(image_uri)
            }
        }
    }

    private fun getImage(): ImageView {
        return image_add
    }

    fun openCamera(){
        val values: ContentValues = ContentValues()
        values.put(MediaStore.Images.Media.TITLE,"New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION,"From Camera")
        image_uri=requireActivity().contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
        val cameraIntent:Intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }
}