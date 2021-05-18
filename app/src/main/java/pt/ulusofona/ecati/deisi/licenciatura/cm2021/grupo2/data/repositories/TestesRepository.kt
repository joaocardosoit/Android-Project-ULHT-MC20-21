package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao.TestesDao
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities.testes

class TestesRepository(private val local: TestesDao) {

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
}