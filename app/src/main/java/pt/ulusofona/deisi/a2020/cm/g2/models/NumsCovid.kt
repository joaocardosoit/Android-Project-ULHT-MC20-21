package pt.ulusofona.deisi.a2020.cm.g2.models

class NumsCovid(val numMortes: Int, val numRecuperados: Int, val numInfetados: Int, val numTotalCasos: Int, val numTotalRecuperados: Int, val numTotalMortes: Int) {

    override fun toString(): String {
        return "$numMortes " + numRecuperados
    }
}