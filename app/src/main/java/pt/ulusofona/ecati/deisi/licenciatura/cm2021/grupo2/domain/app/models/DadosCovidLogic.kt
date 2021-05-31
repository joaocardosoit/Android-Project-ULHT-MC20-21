package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import android.content.Context
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.DadosCovidRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.DadosCovidListener

class DadosCovidLogic(private val dadosCovidRepository: DadosCovidRepository) {

    private var listener: DadosCovidListener? = null

    fun mostraDados(context: Context){
        dadosCovidRepository.mostraDados(context)
    }

    fun getDados(context: Context){
        dadosCovidRepository.getDados(context)
    }

    fun registerListener(listener: DadosCovidListener, context: Context){
        dadosCovidRepository.registerListener(listener, context)
    }

    fun unregisterListener(){
        dadosCovidRepository.unregisterListener()
    }

}