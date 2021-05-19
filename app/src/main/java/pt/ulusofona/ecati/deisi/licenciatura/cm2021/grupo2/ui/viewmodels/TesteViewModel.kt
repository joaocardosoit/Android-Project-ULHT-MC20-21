package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.TestesDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao.TestesDao
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.TestesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.TesteLogic
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments.ListaFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ListaTestesListener

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
}