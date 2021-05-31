package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.ConcelhosDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.RetrofitBuilder
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.ConcelhosRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.ConcelhosLogic
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ConcelhosListener
import retrofit2.Retrofit

class ConcelhosViewModel(application: Application): AndroidViewModel(application) {

    private val concelhos = ConcelhosDatabase.getInstance(application).concelhosDao()
    private val concelhosRepository = ConcelhosRepository(concelhos, RetrofitBuilder.getInstance(ENDPOINT))
    private val concelhosLogic = ConcelhosLogic(concelhosRepository)

    fun getConcelhos(context: Context){
        concelhosLogic.getConcelhos(context)
    }

    fun registerListener(listener: ConcelhosListener, context: Context){
        concelhosLogic.registerListener(listener, context)
    }

    fun unregisterListener(){
        concelhosLogic.unregisterListener()
    }
}