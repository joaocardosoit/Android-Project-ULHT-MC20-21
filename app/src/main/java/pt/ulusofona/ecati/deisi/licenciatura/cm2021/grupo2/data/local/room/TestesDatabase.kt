package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.dao.TestesDao
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities.Teste

@Database(entities = arrayOf(Teste::class), version = 1)
abstract class TestesDatabase: RoomDatabase() {

    abstract fun testeDao(): TestesDao

    companion object{
        private var instance: TestesDatabase? = null

        fun getInstance(applicationContext: Context): TestesDatabase{
            synchronized(this){
                if(instance == null){
                    instance = Room.databaseBuilder(
                        applicationContext,
                        TestesDatabase::class.java,
                        "testes_db"
                    ).build()
                }
                return instance as TestesDatabase
            }
        }
    }
}