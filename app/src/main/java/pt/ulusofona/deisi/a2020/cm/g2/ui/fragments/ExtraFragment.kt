package pt.ulusofona.deisi.a2020.cm.g2.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_extra.*
import pt.ulusofona.deisi.a2020.cm.g2.R
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.Concelhos
import pt.ulusofona.deisi.a2020.cm.g2.ui.adapters.ExtraAdapter
import pt.ulusofona.deisi.a2020.cm.g2.ui.listeners.ListaConcelhosListener
import pt.ulusofona.deisi.a2020.cm.g2.ui.viewmodels.ConcelhosViewModel


class ExtraFragment : Fragment(), ListaConcelhosListener {

    lateinit var viewModel: ConcelhosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_extra, container, false)
        viewModel = ViewModelProviders.of(this).get(ConcelhosViewModel::class.java)
        return view
    }

    override fun onStart() {
        super.onStart()
        context?.let { viewModel.registerListener(this, it) }

        val searchView: SearchView = activity?.toolbar_main?.menu?.findItem(R.id.pesquisa)?.actionView as SearchView
        searchView.queryHint = context?.getString(R.string.pesquisa)
        searchView.setQuery("", false)
        searchView.isIconified = true
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchByConcelho(context!!, query.toUpperCase())
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                return false
            }
        })
        searchView.setOnCloseListener { false }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
    }

    override fun listaConcelhos(listaConcelhos: List<Concelhos>) {
        listaConcelhos.let {
            list_casos_concelho?.layoutManager = LinearLayoutManager(activity as Context)
            list_casos_concelho?.adapter = ExtraAdapter(activity as Context, R.layout.item_lista_concelhos, listaConcelhos.toMutableList() as ArrayList<Concelhos>)
        }
    }

}