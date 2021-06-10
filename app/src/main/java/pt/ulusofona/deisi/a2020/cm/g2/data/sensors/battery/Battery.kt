package pt.ulusofona.deisi.a2020.cm.g2.data.sensors.battery

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.BatteryManager
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.OnBatteryCurrentListener


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

        fun notifyListener(current: Float) {
            listener?.onCurrentChanged(current)
        }

        fun unregisterListener() {
            listener = null
        }

        fun start(context: Context) {
            instance = if (instance == null) Battery(context) else instance
            instance?.start()

        }
    }

    private fun start() {
        handler.postDelayed(this, Time_BETWEEN_UPDATES)
    }

    private fun getBatteryCurrentNow(): Float {
        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
            context.registerReceiver(null, ifilter)
        }
        batteryStatus.let { intent ->
            val level: Int = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            return level * 100 / scale.toFloat()
        }
    }

    override fun run() {
        val currentBattery = getBatteryCurrentNow()
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
            if (currentBattery <= 20) {
                if (!sharedPreferences.getBoolean("darkModeOn", true) && sharedPreferences.getBoolean("popup", true)) {
                    notifyListener(currentBattery)
                    editor.putBoolean("darkMode", true)
                    editor.apply()
                } else {
                    editor.putBoolean("battery", false)
                    editor.apply()
                }
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("battery", false)
                editor.apply()
            }
        handler.postDelayed(this, Time_BETWEEN_UPDATES)

    }
}