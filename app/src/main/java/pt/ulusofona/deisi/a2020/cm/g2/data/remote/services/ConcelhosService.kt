package pt.ulusofona.deisi.a2020.cm.g2.data.remote.services

import pt.ulusofona.deisi.a2020.cm.g2.data.remote.responses.ConcelhosResponse
import retrofit2.Response
import retrofit2.http.GET

interface ConcelhosService {

    @GET("/Requests/get_last_update_counties")
    suspend fun getUltimosDadosConcelhos(): Response<List<ConcelhosResponse>>
}