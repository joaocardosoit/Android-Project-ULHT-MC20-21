package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao.DadosCovidDao
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.DadosCovid
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.responses.DadosCovidResponse
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.services.DadosService
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.DadosCovidListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.sensors.connectivity.Connectivity
import retrofit2.Retrofit

class DadosCovidRepository(private val local: DadosCovidDao, private val retrofit: Retrofit) {

    private var listener: DadosCovidListener? = null

    fun mostraDados(){
        CoroutineScope(Dispatchers.Main).launch {
            listener?.dadosCovid(local.getDados())
        }
    }

    fun getDados(context: Context): DadosCovid?{
        var dadosCovidResponse: DadosCovidResponse? = null
        if(Connectivity.isConnected(context)){
            val service = retrofit.create(DadosService::class.java)
            CoroutineScope(Dispatchers.IO).launch {
                val respose = service.getUltimosDados()
                if(respose.isSuccessful){
                    dadosCovidResponse = respose.body() as DadosCovidResponse
                    val dadosCovid = DadosCovid(dadosCovidResponse!!.data, dadosCovidResponse!!.confirmados, dadosCovidResponse!!.obitos, dadosCovidResponse!!.recuperados, dadosCovidResponse!!.confirmadosNovos, dadosCovidResponse!!.internados, dadosCovidResponse!!.internadosUci)
                    local.insert(dadosCovid)
                    mostraDados()
                } else {
                    respose.message()
                    mostraDados()
                }
            }
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                mostraDados()
            }
        }
        return null
    }

    fun registerListener(listener: DadosCovidListener, context: Context){
        this.listener = listener
        getDados(context)
    }

    fun unregisterListener(){
        listener = null
    }
}