package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.repositories.TestesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities.testes

class TesteLogic(private val repository: TestesRepository) {

    fun guardarTeste(resultado: String, local: String, ano: Int, mes: Int, dia: Int){
        if(resultado == "Positivo" || resultado == "positivo"){
            val teste = Teste(R.drawable.no_foto, "$dia/$mes/$ano", resultado, true, local)
            testes.add(teste)
        } else if (resultado == "Negativo" || resultado == "negativo"){
            val teste = Teste(R.drawable.no_foto,"$dia/$mes/$ano", resultado, false, local)
            testes.add(teste)
        }
    }
}