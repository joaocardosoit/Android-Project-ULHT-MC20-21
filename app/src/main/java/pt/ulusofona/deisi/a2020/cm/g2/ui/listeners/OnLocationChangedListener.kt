package pt.ulusofona.deisi.a2020.cm.g2.ui.listeners

import com.google.android.gms.location.LocationResult

interface OnLocationChangedListener {

    fun onLocationChanged(locationResult: LocationResult)
}