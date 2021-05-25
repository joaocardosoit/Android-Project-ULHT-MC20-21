package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import android.content.Context
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.TestesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities.testes
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ListaTestesListener

class TesteLogic(private val repository: TestesRepository) {

    private var listener: ListaTestesListener? = null

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

    /*
    fun sortedByDescending(context: Context){
        repository.sortedByDescending(context)
    }

    fun sortedByAscending(context: Context){
        repository.sortedByAscending(context)
    }
    */
}