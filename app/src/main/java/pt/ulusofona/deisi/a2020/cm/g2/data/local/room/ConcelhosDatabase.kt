package pt.ulusofona.deisi.a2020.cm.g2.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pt.ulusofona.deisi.a2020.cm.g2.data.local.entities.Concelhos
import pt.ulusofona.deisi.a2020.cm.g2.data.local.room.dao.ConcelhosDao

@Database(entities = arrayOf(Concelhos::class), version = 1)
abstract class ConcelhosDatabase: RoomDatabase() {

    abstract fun concelhosDao(): ConcelhosDao

    companion object{
        private var instance: ConcelhosDatabase? = null

        fun getInstance(applicationContext: Context): ConcelhosDatabase{
            synchronized(this){
                if(instance == null){
                    instance = Room.databaseBuilder(
                            applicationContext,
                            ConcelhosDatabase::class.java,
                            "concelhos_db"
                    ).build()
                }
                return instance as ConcelhosDatabase
            }
        }
    }


}