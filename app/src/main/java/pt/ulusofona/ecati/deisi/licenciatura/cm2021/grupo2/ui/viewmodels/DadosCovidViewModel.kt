package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.DadosCovidDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.RetrofitBuilder
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.DadosCovidRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.DadosCovidLogic
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.DadosCovidListener
import retrofit2.Retrofit

const val ENDPOINT = "https://covid19-api.vost.pt/"
class DadosCovidViewModel(application: Application): AndroidViewModel(application) {

    private val dadosCovid = DadosCovidDatabase.getInstance(application).dadosCovidDao()
    private val dadosCovidRepository = DadosCovidRepository(dadosCovid, RetrofitBuilder.getInstance(ENDPOINT))
    private val dadosCovidLogic = DadosCovidLogic(dadosCovidRepository)

    fun mostraDados(context: Context){
        dadosCovidLogic.mostraDados(context)
    }

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