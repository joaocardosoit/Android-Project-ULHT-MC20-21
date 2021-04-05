package pt.ulusofona.deisi.a2020.cm.g2.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_lista.*
import pt.ulusofona.deisi.a2020.cm.g2.utils.NavigationManager
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.models.NumsCovid
import pt.ulusofona.deisi.a2020.cm.g2.models.Teste
import java.util.*
import kotlin.collections.ArrayList

var numerosCovid: MutableList<NumsCovid> = mutableListOf(NumsCovid(1000, 237, 763, 5000, 1110, 2000))
var testes: MutableList<Teste> = mutableListOf(Teste("1/4/2021", "Positivo", true, "Sintra"))
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        bottomNavigationClick()
        val locale: Locale = resources.configuration.locale
        Locale.setDefault(locale)
    }

    override fun onStart() {
        super.onStart()
        bottom_navigation.selectedItemId = R.id.ic_lista
        NavigationManager.goToListaFragment(supportFragmentManager)
        onClickFab()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ic_perigo -> {
                bottom_navigation.isSelected = false
                NavigationManager.goToListaFragment(supportFragmentManager)}
            R.id.ic_lista -> NavigationManager.goToListaFragment(supportFragmentManager)
            R.id.ic_contactos -> NavigationManager.goToContactosFragment(supportFragmentManager)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        toolbar_main.setOnMenuItemClickListener{ item->
            when(item?.itemId){
                R.id.filtro -> {
                    val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
                    val listaDialog = arrayListOf("Crescente", "Decrescente")
                    dialogBuilder.setTitle("Ordenar Lista")
                    dialogBuilder.setMessage("Escolha uma opção")
                    /*dialogBuilder.setSingleChoiceItems(listaDialog, -1) { _, i ->
                        if (listaDialog[i] == "Crescente"){
                            listaCrescente(testes)
                            Toast.makeText(this, "A lista está agora em ordem crescente", Toast.LENGTH_SHORT).show()
                        } else {
                            listaDecrescente(testes)
                            Toast.makeText(this, "A lista está agora em ordem decrescente", Toast.LENGTH_SHORT).show()
                        }
                    }*/
                    true
                }
                else -> true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onClickFab(){
        ic_perigo_fab.setOnClickListener{
            toolbar_main.title = "MyCovid-19"
            toolbar_main.navigationIcon = null
            toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
            bottom_navigation.selectedItemId = R.id.ic_perigo
            NavigationManager.goToEstouPerigoFragment(supportFragmentManager)
        }
    }

    private fun bottomNavigationClick(){
        bottom_navigation.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId){
                R.id.ic_lista -> {
                    toolbar_main.title = "MyCovid-19"
                    toolbar_main.navigationIcon = null
                    NavigationManager.goToListaFragment(supportFragmentManager)
                    true}
                R.id.ic_contactos -> {
                    toolbar_main.title = "MyCovid-19"
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    NavigationManager.goToContactosFragment(supportFragmentManager)
                    true}
                R.id.ic_dashboard -> {
                    toolbar_main.title = "MyCovid-19"
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    NavigationManager.goToDashboardFragment(supportFragmentManager)
                    true}
                R.id.ic_extra -> {
                    toolbar_main.title = "MyCovid-19"
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    NavigationManager.goToExtraFragment(supportFragmentManager)
                    true}
                else -> true
            }
        }
    }

    private fun listaCrescente(lista: MutableList<Teste>){
        for (i in 0..lista.size-1){
            testes.sortBy { it.data }
        }
    }

    private fun listaDecrescente(lista: MutableList<Teste>){
        for (i in 0..lista.size-1){
            testes.sortByDescending { it.data }
        }
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