package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.ConcelhosDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.RetrofitBuilder
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.ConcelhosRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.ConcelhosLogic
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ListaConcelhosListener

class ConcelhosViewModel(application: Application): AndroidViewModel(application) {

    private val concelhos = ConcelhosDatabase.getInstance(application).concelhosDao()
    private val concelhosRepository = ConcelhosRepository(concelhos, RetrofitBuilder.getInstance(ENDPOINT))
    private val concelhosLogic = ConcelhosLogic(concelhosRepository)

    fun getConcelhos(context: Context){
        concelhosLogic.getConcelhos(context)
    }

    fun registerListener(listener: ListaConcelhosListener, context: Context){
        concelhosLogic.registerListener(listener, context)
    }

    fun unregisterListener(){
        concelhosLogic.unregisterListener()
    }

    fun searchByConcelho(context: Context, nomeConcelho: String){
        concelhosLogic.searchByConcelho(context, nomeConcelho)
    }

    fun searchByDistrito(context: Context, nomeDistrito: String){
        concelhosLogic.searchByConcelho(context, nomeDistrito)
    }
}