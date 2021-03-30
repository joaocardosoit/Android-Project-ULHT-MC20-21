package pt.ulusofona.deisi.a2020.cm.g2

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_contact.*
import java.util.ArrayList

class ContactActivity : AppCompatActivity() {

    val seccao: MutableList<String> = ArrayList()
    val info: MutableList<MutableList<String>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }

    override fun onStart(){
        super.onStart()
        mostrarContactos()

        /*expandable_list_view.setAdapter(ContactActivity(activity as Context, expandable_list_view, seccao,info))
        expandable_list_view.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Log.i("Info", "Clicked: " +seccao[groupPosition] + " -> " + info[groupPosition][childPosition])
            if (groupPosition == 1 && childPosition == 0) {
                Log.i("Info", "Clicked: " +seccao[1] + " -> " + info[1][0])
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:211163060")
                context?.startActivity(intent)

            }else if (groupPosition == 3 && childPosition == 0){
                Log.i("Info", "Clicked: " +seccao[3] + " -> " + info[3][0])
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:217803131")
                context?.startActivity(intent)
            }
            false
        }*/





    }

    fun mostrarContactos(){
        val contactosTelefonico: MutableList<String> = ArrayList()
        contactosTelefonico.add("+351 808 24 24 24" + "<br>" + "Linha SNS 24 para triagem de sintomas e esclarecimento de dúvidas sobre COIVD19")
        contactosTelefonico.add("+351 300 502 502" + "<br>" + "Linha Segurança Social para esclarecimentos sobre assistência à fam+ilia, subsidio de doença e quarentena")
        contactosTelefonico.add("+351 217929714 e +351 961706472" + "<br>" + "Gabinete de Emergência Consular")

        val contactosDigitias: MutableList<String> = ArrayList()
        contactosDigitias.add("covid19.min-saude.pt" + "<br>" + "Plataforma da DGS para esclarecimentos sobre a COVID-19")
        contactosDigitias.add("atendimento@SNS24.gov.pt" + "<br>" + "Canal SNS 24 para esclarecimentos de dúvidas. Não utilizar para diagnóstico médico")
        contactosDigitias.add("gec@mne.pt" + "<br>" + "Gabinete de Emergência Consular")
        contactosDigitias.add("Legislação COVID19" + "<br>" + "Área do Diário da República Eletrónico dedicada à legislação relativa à pandemia")


        seccao.add("Contactos telefónicos COVID19")
        seccao.add("Contactos Digitais COVID19")
        info.add(contactosTelefonico)
        info.add(contactosDigitias)

    }

}