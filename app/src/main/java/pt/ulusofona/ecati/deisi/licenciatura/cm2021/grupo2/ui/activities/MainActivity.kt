package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils.NavigationManager
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.sensors.battery.Battery
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.OnBatteryCurrentListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.TesteViewModel
import java.util.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, OnBatteryCurrentListener {

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
        toolbar_main.menu.findItem(R.id.pesquisa).setVisible(false)
        return true
    }

    private fun onClickFab(){
        ic_perigo_fab.setOnClickListener{
            toolbar_main.title = getString(R.string.titulo)
            toolbar_main.navigationIcon = null
            toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
            toolbar_main.menu.findItem(R.id.pesquisa).setVisible(false)
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
                    toolbar_main.menu.findItem(R.id.pesquisa).setVisible(false)
                    NavigationManager.goToListaFragment(supportFragmentManager)
                    true}
                R.id.ic_contactos -> {
                    toolbar_main.title = getString(R.string.titulo)
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.pesquisa).setVisible(false)
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    NavigationManager.goToContactosFragment(supportFragmentManager)
                    true}
                R.id.ic_dashboard -> {
                    toolbar_main.title = getString(R.string.titulo)
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.pesquisa).setVisible(false)
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    NavigationManager.goToDashboardFragment(supportFragmentManager)
                    true}
                R.id.ic_extra -> {
                    toolbar_main.title = getString(R.string.titulo)
                    toolbar_main.navigationIcon = null
                    toolbar_main.menu.findItem(R.id.filtro).setVisible(false)
                    toolbar_main.menu.findItem(R.id.pesquisa).setVisible(true)
                    NavigationManager.goToExtraFragment(supportFragmentManager)
                    true}
                else -> true
            }
        }
    }

    fun registerListener(onBatteryCurrentListener: OnBatteryCurrentListener){
        Battery.start(this)
        Battery.registerListener(this)
    }
    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCurrentChanged(current: Double) {
    }
}