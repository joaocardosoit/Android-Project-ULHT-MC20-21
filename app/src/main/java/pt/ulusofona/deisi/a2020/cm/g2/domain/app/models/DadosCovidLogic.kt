package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import android.content.Context
import pt.ulusofona.deisi.a2020.cm.g2.data.repositories.DadosCovidRepository
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.DadosCovidListener

class DadosCovidLogic(private val dadosCovidRepository: DadosCovidRepository) {

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