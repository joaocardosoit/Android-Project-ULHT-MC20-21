package pt.ulusofona.deisi.a2020.cm.g2.domain.app.models

import android.content.Context
import pt.ulusofona.deisi.a2020.cm.g2.data.repositories.ConcelhosRepository
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.ListaConcelhosListener

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
    }

    fun searchByDistrito(context: Context, nomeDistrito: String){
        concelhosRepository.searchByDistrito(context, nomeDistrito)
    }
}