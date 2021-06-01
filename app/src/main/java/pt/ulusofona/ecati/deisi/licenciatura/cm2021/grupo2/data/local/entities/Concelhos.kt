package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "concelhos")
data class Concelhos(var data: String) {

    @PrimaryKey
    var uuid: String = UUID.randomUUID().toString()

    var concelho: String = ""
    var incidenciaRisco: String = ""
    var casos14Dias: Int = 0

    constructor(data: String, concelho: String, incidenciaRisco: String, casos14Dias: Int): this(data){
        this.data = data
        this.concelho = concelho
        this.incidenciaRisco = incidenciaRisco
        this.casos14Dias = casos14Dias
    }

}