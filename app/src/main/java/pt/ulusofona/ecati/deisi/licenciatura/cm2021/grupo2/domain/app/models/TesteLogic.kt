package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.TestesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities.testes

class TesteLogic(private val repository: TestesRepository) {

    fun insert(teste: Teste){
        repository.insert(teste)
    }
}