package pt.ulusofona.deisi.a2020.cm.g2.data.local.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "testes")
@Parcelize
data class Teste (val imagem: String?, val data: String, val resultado: String, val estado: Boolean, val local: String): Parcelable {

    @PrimaryKey
    var uuid: String = UUID.randomUUID().toString()
}