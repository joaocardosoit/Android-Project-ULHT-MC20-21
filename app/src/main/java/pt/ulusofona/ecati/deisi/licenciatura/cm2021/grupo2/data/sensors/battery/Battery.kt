package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.sensors.battery

import android.content.Context
import android.content.SharedPreferences
import android.os.BatteryManager
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.OnBatteryCurrentListener
import java.util.*


class Battery private constructor(private val context: Context): Runnable {

    private val Time_BETWEEN_UPDATES = 2000L
    private lateinit var sharedPreferences: SharedPreferences


    companion object {
        private var instance: Battery? = null
        private val handler = android.os.Handler()
        private var listener: OnBatteryCurrentListener? = null

        fun registerListener(listener: OnBatteryCurrentListener) {
            Companion.listener = listener
        }

        fun notifyListeners(current: Int) {
            listener?.onCurrentChanged(current)
        }

        fun unregisterListener() {
            listener = null
        }


        fun start(context: Context) {
            instance = if (instance == null) Battery(
                context
            ) else instance
            instance?.start()

        }
    }

    private fun start() {
        handler.postDelayed(this, Time_BETWEEN_UPDATES)
    }

    private fun getBatteryCurrentNow(): Int {
        val manager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        return manager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
    }

    override fun run() {
        val currentBattery = getBatteryCurrentNow()
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        if (sharedPreferences.getBoolean("locked", true)) {
            if (currentBattery <= 20) {
                val countBoolean = sharedPreferences.getInt("count", 0)
                if (!sharedPreferences.getBoolean(
                        "darkModeOn",
                        true
                    ) && countBoolean == 0 && sharedPreferences.getBoolean("popup", true)
                ) {
                    notifyListeners(
                        currentBattery
                    )
                    editor.putInt("count", 1)
                    editor.putBoolean("darkMode", true)
                    editor.apply()
                } else {
                    editor.putBoolean("battery", false)
                    editor.apply()
                }
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("battery", false)
                editor.putInt("count", 0)
                editor.apply()
            }

        } else if (sharedPreferences.getBoolean("darkMode", true)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            editor.putBoolean("darkModeOn", false)
            editor.putBoolean("darkMode", false)
            editor.putBoolean("battery", false)
            editor.putBoolean("popup", true)
            editor.putInt("count", 0)
            editor.apply()
        }

        handler.postDelayed(this, Time_BETWEEN_UPDATES)

    }
}