package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels

import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.AdicionarTesteLogic

class AdicinarTesteViewModel: ViewModel() {
    private val adicionarTesteLogic = AdicionarTesteLogic()

    fun guardarTeste(resultado: String, local: String, ano: Int, mes: Int, dia: Int){
        adicionarTesteLogic.guardarTeste(resultado, local, ano, mes, dia)
    }
}