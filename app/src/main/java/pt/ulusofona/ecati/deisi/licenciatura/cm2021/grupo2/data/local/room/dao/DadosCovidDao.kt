package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.DadosCovid
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities.Teste

@Dao
interface DadosCovidDao {

    @Insert
    suspend fun insert(dadosCovid: DadosCovid?)

    @Query("SELECT * FROM dados")
    suspend fun getDados(): DadosCovid


}