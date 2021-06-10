package pt.ulusofona.deisi.a2020.cm.g2.data.remote.services

import pt.ulusofona.deisi.a2020.cm.g2.data.remote.responses.DadosCovidResponse
import retrofit2.Response
import retrofit2.http.GET

interface DadosService {

    @GET("/Requests/get_last_update")
    suspend fun getUltimosDados(): Response<DadosCovidResponse>
}