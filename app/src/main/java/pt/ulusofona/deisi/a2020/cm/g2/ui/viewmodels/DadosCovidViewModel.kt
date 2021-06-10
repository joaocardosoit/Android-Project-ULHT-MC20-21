package pt.ulusofona.deisi.a2020.cm.g2.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import pt.ulusofona.deisi.a2020.cm.g2.data.local.room.DadosCovidDatabase
import pt.ulusofona.deisi.a2020.cm.g2.data.remote.RetrofitBuilder
import pt.ulusofona.deisi.a2020.cm.g2.data.repositories.DadosCovidRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.DadosCovidLogic
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.DadosCovidListener

const val ENDPOINT = "https://covid19-api.vost.pt/"
class DadosCovidViewModel(application: Application): AndroidViewModel(application) {

    private val dadosCovid = DadosCovidDatabase.getInstance(application).dadosCovidDao()
    private val dadosCovidRepository = DadosCovidRepository(dadosCovid, RetrofitBuilder.getInstance(ENDPOINT))
    private val dadosCovidLogic = DadosCovidLogic(dadosCovidRepository)


    fun getDados(context: Context){
        dadosCovidLogic.getDados(context)
    }

    fun registerListener(listener: DadosCovidListener, context: Context){
        dadosCovidLogic.registerListener(listener, context)
    }

    fun unregisterListener(){
        dadosCovidLogic.unregisterListener()
    }

}