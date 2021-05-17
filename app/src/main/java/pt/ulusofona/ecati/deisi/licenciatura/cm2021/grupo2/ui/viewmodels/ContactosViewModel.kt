package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels

import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.ContactosLogic

class ContactosViewModel: ViewModel() {

    private val contactosLogic = ContactosLogic()
    var assunto: MutableList<String> = mutableListOf()
    var conteudo: MutableList<MutableList<String>> = mutableListOf()

    fun mostrarContactos(){
        //contactosLogic.mostrarContactos(assunto, conteudo)
    }

}