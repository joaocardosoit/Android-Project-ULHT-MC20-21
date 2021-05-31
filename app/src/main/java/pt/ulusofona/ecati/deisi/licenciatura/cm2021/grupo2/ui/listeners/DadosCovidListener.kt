package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.ui.listeners

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.DadosCovid
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.responses.DadosCovidResponse

interface DadosCovidListener {
    fun dadosCovid(dadosCovid: DadosCovid)
}