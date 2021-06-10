package pt.ulusofona.deisi.a2020.cm.g2.domain.app.models

import android.content.Context
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.Teste
import pt.ulusofona.deisi.a2020.cm.g2.data.repositories.TestesRepository
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.ListaTestesListener

class TesteLogic(private val repository: TestesRepository) {

    fun registerListener(listener: ListaTestesListener, context: Context){
        repository.registerListener(listener,context)
    }

    fun unregisterListener(){
        repository.unregisterListener()
    }

    fun insert(teste: Teste){
        repository.insert(teste)
    }

    fun getAll(context: Context){
        repository.getAll(context)
    }

    fun sortedByDescending(context: Context){
        repository.sortedByDescending(context)
    }

    fun sortedByAscending(context: Context){
        repository.sortedByAscending(context)
    }

}