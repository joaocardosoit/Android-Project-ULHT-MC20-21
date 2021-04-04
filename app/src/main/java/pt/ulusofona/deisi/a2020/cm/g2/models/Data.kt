package pt.ulusofona.deisi.a2020.cm.g2.models


import java.text.DecimalFormat
import java.util.*

class Data {
    fun getData(data: Date): String {
        val mFormat = DecimalFormat("00")
        val calendario: Calendar = GregorianCalendar()
        calendario.time = data
        val ano = calendario[Calendar.YEAR]
        val mes = calendario[Calendar.MONTH] + 1
        val dia = calendario[Calendar.DAY_OF_MONTH]

        return "${mFormat.format(java.lang.Double.valueOf(dia.toDouble()))}-${mFormat.format(java.lang.Double.valueOf(mes.toDouble()))}-${mFormat.format(java.lang.Double.valueOf(ano.toDouble()))}"
    }
}