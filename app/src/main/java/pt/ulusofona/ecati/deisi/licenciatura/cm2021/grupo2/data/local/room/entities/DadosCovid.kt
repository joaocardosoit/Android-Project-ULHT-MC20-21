package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "dados")
data class DadosCovid(var data: String) {

    @PrimaryKey
    var uuid: String = UUID.randomUUID().toString()

    var confirmados: Int = 0
    var obitos: Int = 0
    var recuperados: Int = 0
    var confirmadosNovos: Int = 0
    var internados: Double = 0.0
    var internadosUci: Double = 0.0

    constructor(data: String, confirmados: Int, obitos: Int, recuperados: Int, confirmadosNovos: Int, internados: Double, internadosUci: Double) : this(data) {
        this.data = data
        this.confirmados = confirmados
        this.obitos = obitos
        this.recuperados = recuperados
        this.confirmadosNovos = confirmadosNovos
        this.internados = internados
        this.internadosUci = internadosUci
    }
}