package pt.ulusofona.deisi.a2020.cm.g2.domain.app.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Teste(val imagem: Int?, val data: String, val resultado: String, val estado: Boolean, val local: String): Parcelable {
    override fun toString(): String {
        return "$resultado " + local
    }
}