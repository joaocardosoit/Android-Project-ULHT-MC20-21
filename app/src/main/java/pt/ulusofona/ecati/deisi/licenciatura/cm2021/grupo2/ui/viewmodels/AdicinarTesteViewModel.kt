package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.TestesDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao.TestesDao
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.TestesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.TesteLogic

class AdicinarTesteViewModel(application: Application): AndroidViewModel(application) {
    private val teste = TestesDatabase.getInstance(application).testeDao()
    private val testesRepository = TestesRepository(teste)
    private val adicionarTesteLogic = TesteLogic(testesRepository)

    fun guardarTeste(resultado: String, local: String, ano: Int, mes: Int, dia: Int){
        adicionarTesteLogic.guardarTeste(resultado, local, ano, mes, dia)
    }
}