package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao.DadosCovidDao
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.DadosCovid
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.services.DadosService
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.DadosCovidListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ListaTestesListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils.Connectivity
import retrofit2.Retrofit

class DadosCovidRepository(private val local: DadosCovidDao, private val retrofit: Retrofit) {

    private var listener: DadosCovidListener? = null

    fun mostraDados(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            getDados(context)
            listener?.dadosCovid(local.getDados())
        }
    }

    fun getDados(context: Context): DadosCovid?{
        var dadosCovid: DadosCovid? = null
        if(Connectivity.isConnected(context)){
            val service = retrofit.create(DadosService::class.java)
            CoroutineScope(Dispatchers.IO).launch {
                val respose = service.getUltimosDados()
                if(respose.isSuccessful){
                    dadosCovid = respose.body() as DadosCovid
                    local.insert(dadosCovid)
                }
                else {
                    respose.message()
                }
            }
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                dadosCovid = local.getDados()
            }
        }
        return dadosCovid
    }

    fun registerListener(listener: DadosCovidListener, context: Context){
        this.listener = listener
        getDados(context)
    }

    fun unregisterListener(){
        listener = null
    }
}