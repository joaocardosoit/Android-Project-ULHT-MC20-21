package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Concelhos
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao.ConcelhosDao
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.responses.ConcelhosResponse
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.services.ConcelhosService
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ListaConcelhosListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.sensors.connectivity.Connectivity
import retrofit2.Retrofit

class ConcelhosRepository(private val local: ConcelhosDao, private val retrofit: Retrofit) {

    private var listener: ListaConcelhosListener? = null

    fun mostraConcelhos(listaConcelhos: List<Concelhos>){
        CoroutineScope(Dispatchers.Main).launch {
            listener?.listaConcelhos(listaConcelhos)
        }
    }

    fun getConcelhos(context: Context): List<Concelhos>?{
        var concelhosResponse: List<ConcelhosResponse>
        if(Connectivity.isConnected(context)){
            val service = retrofit.create(ConcelhosService::class.java)
            CoroutineScope(Dispatchers.IO).launch{
                val response = service.getUltimosDadosConcelhos()
                if(response.isSuccessful){
                    concelhosResponse = response.body() as List<ConcelhosResponse>
                    concelhosResponse.forEach {
                        val concelho = Concelhos(it.data, it.concelho, it.incidenciaRisco, it.casos14Dias, it.distrito)
                        local.insert(concelho)
                    }
                    mostraConcelhos(local.getConcelhos())
                } else {
                    response.message()
                    mostraConcelhos(local.getConcelhos())
                }
            }
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                mostraConcelhos(local.getConcelhos())
            }
        }
        return null
    }

    fun searchByConcelho(context: Context, nomeConcelho: String){
        CoroutineScope(Dispatchers.Main).launch {
            listener?.listaConcelhos(local.searchByConcelho(nomeConcelho))
        }
    }

    fun searchByDistrito(context: Context, nomeDistrito: String){
        CoroutineScope(Dispatchers.Main).launch {
            listener?.listaConcelhos(local.searchByConcelho(nomeDistrito))
        }
    }

    fun registerListener(listener: ListaConcelhosListener, context: Context){
        this.listener = listener
        getConcelhos(context)
    }

    fun unregisterListener(){
        listener = null
    }
}