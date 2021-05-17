package pt.ulusofona.deisi.a2020.cm.g2.ui.viewmodels

import androidx.lifecycle.ViewModel
import pt.ulusofona.deisi.a2020.cm.g2.domain.app.models.AdicionarTesteLogic

class AdicinarTesteViewModel: ViewModel() {
    private val adicionarTesteLogic = AdicionarTesteLogic()

    fun guardarTeste(resultado: String, local: String, ano: Int, mes: Int, dia: Int){
        adicionarTesteLogic.guardarTeste(resultado, local, ano, mes, dia)
    }
}