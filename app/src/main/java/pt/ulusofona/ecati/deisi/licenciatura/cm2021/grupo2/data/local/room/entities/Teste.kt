package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.local.room.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "testes")
@Parcelize
data class Teste(val imagem: Int?, val data: String, @PrimaryKey val resultado: String, val estado: Boolean, val local: String): Parcelable {
}