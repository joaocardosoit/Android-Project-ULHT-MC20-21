package pt.ulusofona.deisi.a2020.cm.g2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lista.*
import kotlinx.android.synthetic.main.item_lista.*

const val EXTRA_RESULTADO = "pt.ulusofona.deisi.a2020.cm.g2.RESULTADO"

class ListaActivity : AppCompatActivity() {
    var testes: MutableList<Teste> = mutableListOf(Teste(20, 10, 30, "Lisboa"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
    }

    override fun onStart() {
        super.onStart()

        /*val resultado = intent.getStringExtra(EXTRA_RESULTADO)
        resultado?.let { text_resultado.text = it }*/
        list_casos.layoutManager = LinearLayoutManager(this)
        list_casos.adapter = ListaAdapter(this, R.layout.item_lista, testes)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}