package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.fragments.*
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models.Teste

abstract class NavigationManager {
    companion object{
        private fun placeFragment(fm: FragmentManager, fragment: Fragment){
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame_layout, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }

        fun goToListaFragment(fm: FragmentManager){
            placeFragment(fm, ListaFragment())
        }

        fun goToContactosFragment(fm: FragmentManager){
            placeFragment(fm, ContactosFragment())
        }

        fun goToAdicionarTesteFragment(fm: FragmentManager){
            placeFragment(fm, AdicionarTesteFragment())
        }

        fun goToEstouPerigoFragment(fm: FragmentManager){
            placeFragment(fm, EstouPerigoFragment())
        }

        fun goToDashboardFragment(fm: FragmentManager){
            placeFragment(fm, DashboardFragment())
        }

        fun goToDetalhesTesteFragment(fm: FragmentManager, teste: Teste){
            val bundle = Bundle()
            bundle.putParcelable("Teste", teste)
            val detalhesTesteFragment = DetalhesTesteFragment()
            detalhesTesteFragment.arguments = bundle

            placeFragment(fm, detalhesTesteFragment)
        }

        fun goToExtraFragment(fm: FragmentManager){
            placeFragment(fm, ExtraFragment())
        }
    }
}