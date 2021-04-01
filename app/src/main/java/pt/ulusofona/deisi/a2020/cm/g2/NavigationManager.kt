package pt.ulusofona.deisi.a2020.cm.g2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

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
    }
}