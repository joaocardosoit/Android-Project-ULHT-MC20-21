package pt.ulusofona.deisi.a2020.cm.g2.domain.app.models

import android.widget.DatePicker
import kotlinx.android.synthetic.main.fragment_adicionar_teste.*
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.ui.activities.testes

class AdicionarTesteLogic {

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