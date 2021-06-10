package pt.ulusofona.deisi.a2020.cm.g2.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.Concelhos

@Dao
interface ConcelhosDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(concelhos: Concelhos)

    @Query("SELECT * FROM concelhos")
    suspend fun getConcelhos(): List<Concelhos>

    @Query("SELECT * FROM concelhos WHERE concelho = :concelho")
    suspend fun searchByConcelho(concelho: String): List<Concelhos>

    @Query("SELECT * FROM concelhos WHERE distrito = :distrito")
    suspend fun searchByDistrito(distrito: String): List<Concelhos>

    @Delete
    suspend fun delete(concelhos: Concelhos)
}