package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "concelhos")
class Concelhos(val data: String) {

    @PrimaryKey
    var uuid: String = UUID.randomUUID().toString()


}