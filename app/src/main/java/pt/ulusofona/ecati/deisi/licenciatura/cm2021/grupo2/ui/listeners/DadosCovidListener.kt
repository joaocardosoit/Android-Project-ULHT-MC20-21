package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.DadosCovid

interface DadosCovidListener {
    fun dadosCovid(dadosCovid: DadosCovid?)
}