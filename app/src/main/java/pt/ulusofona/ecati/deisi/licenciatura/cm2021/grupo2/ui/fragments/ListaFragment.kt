package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments

import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_lista.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils.NavigationManager
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.adapters.ListaAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.OnClickItemListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners.ListaTestesListener
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.viewmodels.TesteViewModel

class ListaFragment : Fragment(), OnClickItemListener, ListaTestesListener {

    lateinit var viewModel: TesteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        viewModel = ViewModelProviders.of(this).get(TesteViewModel::class.java)
        return view
    }

    override fun onStart() {
        super.onStart()
        context?.let { viewModel.registerListener(this, it) }

        if (!activity?.toolbar_main?.menu?.findItem(R.id.filtro)?.isVisible!!){
            activity?.toolbar_main?.menu?.findItem(R.id.filtro)?.setVisible(true)
        }

        activity?.toolbar_main?.setOnMenuItemClickListener { item ->
            when(item?.itemId){
                R.id.filtro -> {
                    val listaDialog = arrayOf(context?.getString(R.string.crescente), context?.getString(R.string.decrescente))
                    val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity as Context)
                    dialogBuilder.setTitle(getString(R.string.ordenar_lista))
                    dialogBuilder.setSingleChoiceItems(listaDialog, -1) { dialogInterface, i ->
                        if (listaDialog[i] == getString(R.string.crescente)){
                            viewModel.sortedByAscending(context!!)
                            Toast.makeText(context, getString(R.string.lista_crescente_msg), Toast.LENGTH_SHORT).show()
                        } else {
                            viewModel.sortedByDescending(context!!)
                            Toast.makeText(context, getString(R.string.lista_decrescente_msg), Toast.LENGTH_SHORT).show()
                        }
                    }
                    dialogBuilder.setPositiveButton(getString(R.string.ok)){ dialog, _ ->
                        dialog.dismiss()
                    }
                    dialogBuilder.setNeutralButton(getString(R.string.cancelar)){ dialog, _ ->
                        dialog.cancel()
                    }
                    val dialogCreate = dialogBuilder.create()
                    dialogCreate.show()
                    true
                }
                else -> true
            }

            true
        }

        fab_add.setOnClickListener(){
            activity?.toolbar_main?.menu?.findItem(R.id.filtro)?.setVisible(false)
            activity?.supportFragmentManager?.let { NavigationManager.goToAdicionarTesteFragment(it) }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onClickItem(teste: Teste) {
        activity?.toolbar_main?.menu?.findItem(R.id.filtro)?.setVisible(false)
        activity?.supportFragmentManager?.let { NavigationManager.goToDetalhesTesteFragment(it, teste) }
    }

    override fun listaTestes(listaTestes: List<Teste>) {
        listaTestes.let {
            list_casos?.layoutManager = LinearLayoutManager(activity as Context)
            list_casos?.adapter = ListaAdapter(activity as Context, R.layout.item_lista, listaTestes.toMutableList() as ArrayList<Teste>, this)
        }
    }

}