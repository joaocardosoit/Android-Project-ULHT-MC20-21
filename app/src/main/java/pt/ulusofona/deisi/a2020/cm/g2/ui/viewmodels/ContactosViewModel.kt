package pt.ulusofona.deisi.a2020.cm.g2.ui.viewmodels

import androidx.lifecycle.ViewModel
import pt.ulusofona.deisi.a2020.cm.g2.domain.app.models.ContactosLogic

class ContactosViewModel: ViewModel() {

    private val contactosLogic = ContactosLogic()
    val assunto: MutableList<String> = mutableListOf()
    val conteudo: MutableList<MutableList<String>> = mutableListOf()

    fun mostrarContactos(){
        contactosLogic.mostrarContactos()
    }

}