package pt.ulusofona.deisi.a2020.cm.g2.data.repositories

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.deisi.a2020.cm.g2.data.local.room.dao.TestesDao
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.Teste
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.ListaTestesListener

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
            CoroutineScope(Dispatchers.Main).launch {
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

    fun sortedByAscending(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val testes = local.sortedByAscending()
            CoroutineScope(Dispatchers.Main).launch {
                listener?.listaTestes(testes)
            }
        }
    }

    fun sortedByDescending(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            val testes = local.sortedByDescending()
            CoroutineScope(Dispatchers.Main).launch {
                listener?.listaTestes(testes)
            }
        }
    }
}