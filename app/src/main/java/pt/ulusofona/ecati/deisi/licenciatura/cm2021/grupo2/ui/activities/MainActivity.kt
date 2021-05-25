package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils.NavigationManager
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.Concelhos
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.NumsCovid
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.TesteViewModel
import java.util.*

var numerosCovid: MutableList<NumsCovid> = mutableListOf(NumsCovid(1000, 237, 763, 5000, 1110, 2000))
var listaConcelhos: MutableList<Concelhos> = mutableListOf(Concelhos("Évora", 90, 321, 455),
        Concelhos("Lisboa", 450, 12, 500),
        Concelhos("Amadora", 210, 45, 150),
        Concelhos("Porto", 600, 115, 240),
        Concelhos("Sintra", 50, 76, 90)
)
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var viewModel: TesteViewModel

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

    /*override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val listaDialog = arrayOf("Crescente", "Decrescente")
        toolbar_main.setOnMenuItemClickListener{ item ->
            when(item?.itemId){
                R.id.filtro -> {
                    val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
                    dialogBuilder.setTitle("Ordenar Lista")
                    dialogBuilder.setSingleChoiceItems(listaDialog, -1) { _, i ->
                        if (listaDialog[i] == "Crescente"){
                            listaCrescente(testes)
                            Toast.makeText(this, "A lista está agora em ordem crescente", Toast.LENGTH_SHORT).show()
                        } else {
                            listaDecrescente(testes)
                            Toast.makeText(this, "A lista está agora em ordem decrescente", Toast.LENGTH_SHORT).show()
                        }
                    }
                    dialogBuilder.setPositiveButton("Ok"){ _, _ ->
                    }
                    val dialogCreate = dialogBuilder.create()
                    dialogCreate.show()
                    true
                }
                else -> true
            }
        }
        return super.onOptionsItemSelected(item)
    }*/

    private fun onClickFab(){
        ic_perigo_fab.setOnClickListener{
            toolbar_main.title = getString(R.string.titulo)
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
                    toolbar_main.title = getString(R.string.titulo)
                    toolbar_main.navigationIcon = null
                    NavigationManager.goToListaFragment(supportFragmentManager)
                    true}
                R.id.ic_contactos -> {
                    toolbar_main.title = getString(R.string.titulo)
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    NavigationManager.goToContactosFragment(supportFragmentManager)
                    true}
                R.id.ic_dashboard -> {
                    toolbar_main.title = getString(R.string.titulo)
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    NavigationManager.goToDashboardFragment(supportFragmentManager)
                    true}
                R.id.ic_extra -> {
                    toolbar_main.title = getString(R.string.titulo)
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    NavigationManager.goToExtraFragment(supportFragmentManager)
                    true}
                else -> true
            }
        }
    }

    private fun listaDecrescente(lista: MutableList<Teste>){
        for (i in 0..lista.size-1){
            lista.sortBy { it.data }
        }
    }

    private fun listaCrescente(lista: MutableList<Teste>){
        for (i in 0..lista.size-1){
            lista.sortByDescending { it.data }
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