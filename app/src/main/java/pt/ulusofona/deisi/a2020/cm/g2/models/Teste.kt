package pt.ulusofona.deisi.a2020.cm.g2.models

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
class Teste(val data: String, val resultado: String, val estado: Boolean, val local: String): Parcelable {
    override fun toString(): String {
        return "$resultado " + local
    }
}