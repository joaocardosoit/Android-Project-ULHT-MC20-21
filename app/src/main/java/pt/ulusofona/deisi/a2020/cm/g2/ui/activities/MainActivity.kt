package pt.ulusofona.deisi.a2020.cm.g2.ui.activities


import android.app.AlertDialog
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.LocationResult
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_estou_perigo.*
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.Concelhos
import pt.ulusofona.deisi.a2020.cm.g2.grupo2.R
import pt.ulusofona.deisi.a2020.cm.g2.data.sensors.battery.Battery
import pt.ulusofona.deisi.a2020.cm.g2.data.sensors.location.FusedLocation
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.ListaConcelhosListener
import pt.ulusofona.deisi.a2020.cm.g2.ui.utils.NavigationManager
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.OnBatteryCurrentListener
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.OnLocationChangedListener
import pt.ulusofona.deisi.a2020.cm.g2.ui.viewmodels.ConcelhosViewModel
import java.util.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, OnBatteryCurrentListener, OnLocationChangedListener, ListaConcelhosListener {

    private var currentBattery: OnBatteryCurrentListener? = null
    var listaDeConcelhos : List <Concelhos>? = null
    var lastDistrito : String = ""
    val red = Color.rgb(143, 29, 29)
    val green = Color.rgb(28, 128, 28)
    val yellow = Color.rgb(170, 170, 2)
    val orange = Color.rgb(170, 93, 0)
    lateinit var viewModel: ConcelhosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        bottomNavigationClick()
        bottom_navigation.selectedItemId = R.id.ic_lista
        NavigationManager.goToListaFragment(supportFragmentManager)
        val locale: Locale = resources.configuration.locale
        Locale.setDefault(locale)
        val sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()
        editor.putBoolean("popup",true)
        editor.apply()
        viewModel = ViewModelProviders.of(this).get(ConcelhosViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        onClickFab()
        Battery.registerListener(this)
        FusedLocation.registerListener(this)
        viewModel.registerListener(this, this)
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

    fun notifyListener(current: Float){
        currentBattery?.onCurrentChanged(current)
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

    private fun popUpBattery(){
        val sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this)
        val editor: SharedPreferences.Editor=sharedPreferences.edit()
        editor.putBoolean("popup", true)
        editor.apply()
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val dialog: AlertDialog = builder.setTitle(R.string.bateria)
                .setMessage(R.string.darkmode)
                .setPositiveButton(R.string.sim) { _, _ ->
                    editor.putBoolean("darkModeOn",true)
                    editor.putBoolean("popup", false)
                    editor.apply()
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                .setNegativeButton(R.string.nao) { _, _ ->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    editor.putBoolean("cancelDarkMode",true)
                    editor.putBoolean("popup", false)
                    editor.apply()
                }.create()
        dialog.show()

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(this,R.color.black))

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(this,R.color.black))
    }

    override fun onCurrentChanged(current: Float) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("darkModeOn", true)
        editor.apply()
        popUpBattery()
    }

    override fun onLocationChanged(locationResult: LocationResult) {
        val location = locationResult.lastLocation
        val geocoder = Geocoder(this)
        Log.i("OLAAA", "OLAAAAA")
        val listaResultados = geocoder.getFromLocation(location.latitude, location.longitude, 1)
        if (!listaResultados[0].adminArea.equals(lastDistrito) && listaDeConcelhos != null){
            lastDistrito = listaResultados[0].adminArea
            for(c in listaDeConcelhos!!){
                Log.i("ALOOOOO", "ALOOOOOOO")
                if (c.distrito.equals(lastDistrito.toUpperCase())){
                    if(c.incidenciaRisco.equals("Moderado") || c.incidenciaRisco.equals("Baixo a Moderado")){
                        ic_perigo_fab.setBackgroundTintList(ColorStateList.valueOf(green))
                    } else if (c.incidenciaRisco.equals("Elevado")){
                        ic_perigo_fab.setBackgroundTintList(ColorStateList.valueOf(yellow))
                    } else if (c.incidenciaRisco.equals("Muito Elevado")){
                        ic_perigo_fab.setBackgroundTintList(ColorStateList.valueOf(orange))
                    } else if (c.incidenciaRisco.equals("Extremamente Elevado")){
                        ic_perigo_fab.setBackgroundTintList(ColorStateList.valueOf(red))
                    }
                }
            }
        }
    }

    override fun listaConcelhos(listaConcelhos: List<Concelhos>) {
        listaDeConcelhos = listaConcelhos
    }

}