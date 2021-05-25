package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao.TestesDao
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities.testes
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ListaTestesListener

class TestesRepository(private val local: TestesDao) {
    private var listener: ListaTestesListener? = null

    fun insert(teste: Teste){
        CoroutineScope(Dispatchers.IO).launch {
            if(teste.resultado == "Positivo" || teste.resultado == "positivo"){
                teste.estado
                local.insert(teste)
            } else if (teste.resultado == "Negativo" || teste.resultado == "negativo"){
                !teste.estado
                local.insert(teste)
            }
        }
    }

    fun getAll(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val testes = local.getAll()
            CoroutineScope(Dispatchers.IO).launch {
                listener?.listaTestes(testes)
            }
        }
    }

    fun registerListener(listener: ListaTestesListener, context: Context){
        this.listener = listener
        getAll(context)
    }

    fun unregisterListener(){
        this.listener = null
    }

    /*
    fun sortedByDescending(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val testes = local.getAll()
            CoroutineScope(Dispatchers.IO).launch {
                listener?.listaTestes(testes)
            }
        }
    }

    fun sortedByAscending(){
        CoroutineScope(Dispatchers.IO).launch {
            val testes = local.sortedByAscending()
            CoroutineScope(Dispatchers.IO).launch {
                listener?.listaTestes(testes)
            }
        }
    }
     */
}