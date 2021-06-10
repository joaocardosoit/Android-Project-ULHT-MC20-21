package pt.ulusofona.deisi.a2020.cm.g2.data.sensors.location

import android.content.Context
import android.os.Looper
import android.util.Log
import com.google.android.gms.location.*
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.OnLocationChangedListener

class FusedLocation private constructor(context: Context) : LocationCallback(){

    private val TAG = FusedLocation::class.java.simpleName

    private val TIME_BETWEEN_UPDATES = 20 * 1000L
    private var locationRequest: LocationRequest? = null
    private var client = FusedLocationProviderClient(context)

    init {
        locationRequest = LocationRequest()
        locationRequest?.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest?.interval = TIME_BETWEEN_UPDATES

        val locationSettingsRequest = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest!!)
            .build()

        LocationServices.getSettingsClient(context)
            .checkLocationSettings(locationSettingsRequest)
    }

    companion object{
        private var listener: OnLocationChangedListener? = null
        private var instance: FusedLocation? = null

        fun registerListener(listener: OnLocationChangedListener){
            Companion.listener = listener
        }

        fun unregisterListener(){
            listener = null
        }

        fun notifyListener(locationResult: LocationResult){
            listener?.onLocationChanged(locationResult)
        }

        fun start(context: Context){
            instance = if(instance == null) FusedLocation(context) else instance
            instance?.startLocationUpdates()
        }
    }

    private fun startLocationUpdates(){
        client.requestLocationUpdates(locationRequest!!, this, Looper.myLooper()!!)
    }

    override fun onLocationResult(locationResult: LocationResult?) {
        Log.i(TAG, locationResult?.lastLocation.toString())
        locationResult?.let { notifyListener(it) }
        super.onLocationResult(locationResult)
    }
}