package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R

class ContactosLogic {

    //val assunto: MutableList<String> = mutableListOf()
    //val conteudo: MutableList<MutableList<String>> = mutableListOf()
    private val contactosTelefonico: MutableList<String> = ArrayList()
    private val contactosDigitias: MutableList<String> = ArrayList()

    fun mostrarContactos(assunto: MutableList<String>, conteudo: MutableList<MutableList<String>>){
        contactosTelefonico.add(getString(R.string.num_telefone_1) + "\n" + getString(R.string.descricao_contactos_1))
        contactosTelefonico.add(getString(R.string.num_telefone_2) + "\n" + getString(R.string.descricao_contactos_2))
        contactosTelefonico.add(getString(R.string.num_telefone_3) + " \n" + getString(R.string.num_telefone_4) + "\n" + getString(
            R.string.descricao_contactos_3))

        contactosDigitias.add(getString(R.string.contacto_digital_1) + "\n" + getString(R.string.descricao_contacto_digital_1))
        contactosDigitias.add(getString(R.string.contacto_digital_2) + "\n" + getString(R.string.descricao_contacto_digital_2))
        contactosDigitias.add(getString(R.string.contacto_digital_3) + "\n" + getString(R.string.descricao_contacto_digital_3))
        contactosDigitias.add(getString(R.string.contacto_digital_4) + "\n" + getString(R.string.descricao_contacto_digital_4))


        assunto.add(getString(R.string.contactos_telefonicos))
        assunto.add(getString(R.string.contactos_digitais))
        conteudo.add(contactosTelefonico)
        conteudo.add(contactosDigitias)

    }
}