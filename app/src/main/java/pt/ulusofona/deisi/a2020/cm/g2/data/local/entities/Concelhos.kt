package pt.ulusofona.deisi.a2020.cm.g2.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "concelhos")
data class Concelhos(var data: String) {

    @PrimaryKey
    var concelho: String = ""
    var incidenciaRisco: String = ""
    var casos14Dias: Int = 0
    var distrito: String = ""

    constructor(data: String, concelho: String, incidenciaRisco: String, casos14Dias: Int, distrito: String): this(data){
        this.data = data
        this.concelho = concelho
        this.incidenciaRisco = incidenciaRisco
        this.casos14Dias = casos14Dias
        this.distrito = distrito
    }

}