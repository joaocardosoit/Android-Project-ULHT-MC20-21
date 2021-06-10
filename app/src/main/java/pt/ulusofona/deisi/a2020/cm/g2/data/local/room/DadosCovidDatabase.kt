package pt.ulusofona.deisi.a2020.cm.g2.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pt.ulusofona.deisi.a2020.cm.g2.data.local.room.dao.DadosCovidDao
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.DadosCovid

@Database(entities = arrayOf(DadosCovid::class), version = 1)
abstract class DadosCovidDatabase: RoomDatabase() {

    abstract fun dadosCovidDao(): DadosCovidDao

    companion object{
        private var instance: DadosCovidDatabase? = null

        fun getInstance(applicationContext: Context): DadosCovidDatabase{
            synchronized(this){
                if(instance == null){
                    instance = Room.databaseBuilder(
                            applicationContext,
                            DadosCovidDatabase::class.java,
                            "dadoscovid_db"
                    ).build()
                }
                return instance as DadosCovidDatabase
            }
        }
    }
}