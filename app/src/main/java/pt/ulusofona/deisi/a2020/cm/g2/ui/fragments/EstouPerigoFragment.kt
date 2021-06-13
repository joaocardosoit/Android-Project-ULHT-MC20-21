package pt.ulusofona.deisi.a2020.cm.g2.ui.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.LocationResult
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_estou_perigo.*
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.Concelhos
import pt.ulusofona.deisi.a2020.cm.g2.grupo2.R
import pt.ulusofona.deisi.a2020.cm.g2.data.sensors.location.FusedLocation
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.ListaConcelhosListener
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.OnLocationChangedListener
import pt.ulusofona.deisi.a2020.cm.g2.ui.viewmodels.ConcelhosViewModel

const val REQUEST_CODE = 100
class EstouPerigoFragment : PermissionedFragment(REQUEST_CODE), OnLocationChangedListener,  ListaConcelhosListener{

    lateinit var viewModel: ConcelhosViewModel
    var listaDeConcelhos : List <Concelhos>? = null
    var lastDistrito : String = ""
    val red = Color.rgb(143, 29, 29)
    val green = Color.rgb(28, 128, 28)
    val yellow = Color.rgb(170, 170, 2)
    val orange = Color.rgb(170, 93, 0)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_estou_perigo, container, false)
        viewModel = ViewModelProviders.of(this).get(ConcelhosViewModel::class.java)
        return view
    }

    override fun onStart() {
        super.onRequestPermissions(activity?.baseContext!!, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION))
        super.onStart()
        viewModel.registerListener(this, context!!)
        sosCard.setCardBackgroundColor(Color.YELLOW)
    }

    override fun onRequestPermissionsSuccess() {
        FusedLocation.registerListener(this)
    }

    override fun onRequestPermissionsFailure() {
        Toast.makeText(context, getString(R.string.permissões), Toast.LENGTH_SHORT).show()
    }

    override fun onLocationChanged(locationResult: LocationResult) {
        val location = locationResult.lastLocation
        val geocoder = Geocoder(context)
        val listaResultados = geocoder.getFromLocation(location.latitude, location.longitude, 1)
        val cardview : CardView? = sosCard
        if (!listaResultados[0].adminArea.equals(lastDistrito) && listaDeConcelhos != null){
            text_posicao?.text = listaResultados[0].adminArea
            lastDistrito = listaResultados[0].adminArea
            for(c in listaDeConcelhos!!){
                if (c.distrito.equals(lastDistrito.toUpperCase())){
                    if(c.incidenciaRisco.equals("Moderado") || c.incidenciaRisco.equals("Baixo a Moderado")){
                        text_risco.text = getString(R.string.moderada)
                        cardview?.setCardBackgroundColor(green)
                    } else if (c.incidenciaRisco.equals("Elevado")){
                        text_risco.text = getString(R.string.elevada)
                        cardview?.setCardBackgroundColor(yellow)
                    } else if (c.incidenciaRisco.equals("Muito Elevado")){
                        text_risco.text = getString(R.string.muito_elevada)
                        cardview?.setCardBackgroundColor(orange)
                    } else if (c.incidenciaRisco.equals("Extremamente Elevado")){
                        text_risco.text = getString(R.string.extremamente_elevada)
                        cardview?.setCardBackgroundColor(red)
                    }
                }
            }
        }
    }

    override fun listaConcelhos(listaConcelhos: List<Concelhos>) {
        listaDeConcelhos = listaConcelhos
    }
}