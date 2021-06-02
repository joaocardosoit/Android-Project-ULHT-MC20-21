package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import android.content.Context
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.ConcelhosRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ListaConcelhosListener

class ConcelhosLogic(private val concelhosRepository: ConcelhosRepository) {

    fun getConcelhos(context: Context){
        concelhosRepository.getConcelhos(context)
    }

    fun registerListener(listener: ListaConcelhosListener, context: Context){
        concelhosRepository.registerListener(listener, context)
    }

    fun unregisterListener(){
        concelhosRepository.unregisterListener()
    }

    fun searchByConcelho(context: Context, nomeConcelho: String){
        concelhosRepository.searchByConcelho(context, nomeConcelho)
        println("LOGICA")
    }
}