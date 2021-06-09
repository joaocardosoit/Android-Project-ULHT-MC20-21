package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners

import com.google.android.gms.location.LocationResult
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Concelhos

interface OnLocationChangedListener {

    fun onLocationChanged(locationResult: LocationResult, listaConcelhos: List<Concelhos>)
}