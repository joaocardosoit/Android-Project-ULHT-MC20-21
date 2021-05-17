package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.domain.app.models

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R

class NumsCovid(val numMortes: Int, val numRecuperados: Int, val numInfetados: Int, val numTotalCasos: Int, val numTotalRecuperados: Int, val numTotalMortes: Int) {

    override fun toString(): String {
        return "$numMortes " + numRecuperados
    }
}