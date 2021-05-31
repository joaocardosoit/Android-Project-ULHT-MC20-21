package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.services

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.DadosCovid
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface DadosService {
    @GET("/Requests/get_last_update")
    suspend fun getUltimosDados(): Response<DadosCovid>
}