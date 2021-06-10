package pt.ulusofona.deisi.a2020.cm.g2.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.deisi.a2020.cm.g2.data.local.room.TestesDatabase
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.Teste
import pt.ulusofona.deisi.a2020.cm.g2.data.repositories.TestesRepository
import pt.ulusofona.deisi.a2020.cm.g2.domain.app.models.TesteLogic
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.ListaTestesListener

class TesteViewModel(application: Application): AndroidViewModel(application) {
    private val teste = TestesDatabase.getInstance(application).testeDao()
    private val testesRepository = TestesRepository(teste)
    private val testeLogic = TesteLogic(testesRepository)

    fun registerListener(listener: ListaTestesListener, context: Context){
        testeLogic.registerListener(listener, context)
    }

    fun unregisterListener(){
        testeLogic.unregisterListener()
    }

    fun insert(teste: Teste){
        testeLogic.insert(teste)
    }

    fun getAll(context: Context){
        testeLogic.getAll(context)
    }


    fun sortedByDescending(context: Context){
        CoroutineScope(Dispatchers.Main).launch {
            testeLogic.sortedByDescending(context)
        }
    }

    fun sortedByAscending(context: Context){
        CoroutineScope(Dispatchers.Main).launch {
            testeLogic.sortedByAscending(context)
        }
    }

}