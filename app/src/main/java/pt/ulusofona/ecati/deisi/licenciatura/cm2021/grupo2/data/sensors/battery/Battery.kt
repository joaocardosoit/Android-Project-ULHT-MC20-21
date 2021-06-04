package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.sensors.battery

import android.content.Context
import android.os.BatteryManager
import android.util.Log
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.OnBatteryCurrentListener
import java.util.logging.Handler

class Battery private constructor(private val context: Context): Runnable{

    private val TAG = Battery::class.java.simpleName
    private val TIME_BETWEEN_UPDATES = 20 * 1000L

    companion object{

        private var instance: Battery? = null
        private val handler = android.os.Handler()
        private var listener: OnBatteryCurrentListener? = null

        fun start(context: Context){
            instance = if (instance == null) Battery(context) else instance
        }

        fun registerListener(listener: OnBatteryCurrentListener){
            this.listener = listener
        }

        fun unregisterListener(){
            listener = null
        }

        fun notifyListener(currentBattery: Double){
            listener?.onCurrentChanged(currentBattery)
        }
    }

    private fun start(){
        handler.postDelayed(this, TIME_BETWEEN_UPDATES)
    }

    private fun getBatteryCurrentNow(): Double{
        val manager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        val value = manager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CURRENT_NOW)
        return if (value != 0 && value != Int.MIN_VALUE) value.toDouble() / 1000000 else 0.0
    }

    override fun run() {
        val current = getBatteryCurrentNow()
        Log.i(TAG, current.toString())
        handler.postDelayed(this, TIME_BETWEEN_UPDATES)
        notifyListener(current)
    }

}