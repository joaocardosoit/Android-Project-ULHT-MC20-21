package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.sensors.battery.Battery

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        Battery.start(this)

        val sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()
        editor.putBoolean("battery",false)
        editor.putInt("count",0)
        editor.putBoolean("cancelDarkode",false)
        editor.putBoolean("darkModeOn",false)
        editor.putBoolean("darkMode",false)
        editor.putBoolean("popup",false)
        editor.apply()

    }
}