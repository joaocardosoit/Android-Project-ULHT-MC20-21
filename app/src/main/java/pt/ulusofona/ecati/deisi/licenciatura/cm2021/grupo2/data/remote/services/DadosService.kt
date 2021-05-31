package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.services

import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.responses.DadosConcelhosResponse
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.responses.DadosCovidResponse
import retrofit2.Response
import retrofit2.http.GET

interface DadosService {
    @GET("/Requests/get_last_update")
    suspend fun getUltimosDados(): Response<DadosCovidResponse>

    @GET("/Requests/get_last_update_counties")
    suspend fun getUltimosDadosConcelhos(): Response<List<DadosConcelhosResponse>>
}