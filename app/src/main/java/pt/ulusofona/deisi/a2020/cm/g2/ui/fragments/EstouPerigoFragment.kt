package pt.ulusofona.deisi.a2020.cm.g2.ui.fragments

import android.location.Geocoder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.LocationResult
import kotlinx.android.synthetic.main.fragment_estou_perigo.*
import pt.ulusofona.deisi.a2020.cm.g2.grupo2.R
import pt.ulusofona.deisi.a2020.cm.g2.data.sensors.location.FusedLocation
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.OnLocationChangedListener
import pt.ulusofona.deisi.a2020.cm.g2.ui.viewmodels.ConcelhosViewModel

class EstouPerigoFragment : Fragment(), OnLocationChangedListener {

    lateinit var viewModel: ConcelhosViewModel
    private var locationListener: OnLocationChangedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_estou_perigo, container, false)
        viewModel = ViewModelProviders.of(this).get(ConcelhosViewModel::class.java)
        return view
    }

    override fun onStart() {
        super.onStart()
        FusedLocation.registerListener(this)
    }

    fun registerListener(listener: OnLocationChangedListener){
        this.locationListener = listener
    }

    fun notifyListener(currentLocation: LocationResult){
        locationListener?.onLocationChanged(currentLocation)
    }

    override fun onLocationChanged(locationResult: LocationResult) {
        val location = locationResult.lastLocation
        val geocoder = Geocoder(context)
        val listaResultados = geocoder.getFromLocation(location.latitude, location.longitude, 1)
        viewModel.searchByDistrito(context!!, listaResultados[0].adminArea)
        text_posicao.text = listaResultados[0].adminArea
    }
}