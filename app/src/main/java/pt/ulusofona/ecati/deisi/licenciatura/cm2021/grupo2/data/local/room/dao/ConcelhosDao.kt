package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Concelhos

@Dao
interface ConcelhosDao {

    @Insert
    suspend fun insert(concelhos: Concelhos)

    @Query("SELECT * FROM concelhos")
    suspend fun getConcelhos(): List<Concelhos>
}