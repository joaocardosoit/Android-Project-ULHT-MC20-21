package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import android.content.Context
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.ConcelhosRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ConcelhosListener

class ConcelhosLogic(private val concelhosRepository: ConcelhosRepository) {

    fun getConcelhos(context: Context){
        concelhosRepository.getConcelhos(context)
    }

    fun registerListener(listener: ConcelhosListener, context: Context){
        concelhosRepository.registerListener(listener, context)
    }

    fun unregisterListener(){
        concelhosRepository.unregisterListener()
    }
}