package pt.ulusofona.deisi.a2020.cm.g2.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Teste(val data: String, val resultado: String, val estado: Boolean, val local: String): Parcelable {
}