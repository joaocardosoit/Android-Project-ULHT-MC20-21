package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.sensors.battery.Battery
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.sensors.location.FusedLocation

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        Battery.start(this)
        FusedLocation.start(this)
        val sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()
        editor.putBoolean("battery",false)
        editor.putBoolean("cancelDarkMode",false)
        editor.putBoolean("darkModeOn",false)
        editor.putBoolean("darkMode",false)
        editor.putBoolean("popup",false)
        editor.apply()

    }
}