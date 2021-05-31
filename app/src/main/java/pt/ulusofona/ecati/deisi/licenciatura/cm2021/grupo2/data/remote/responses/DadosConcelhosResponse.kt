package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.responses

import com.google.gson.annotations.SerializedName

data class DadosConcelhosResponse(
        @SerializedName("data") val data: String,
        @SerializedName("concelho") val concelho: String,
        @SerializedName("confirmados_14") val confirmados14: Int,
        @SerializedName("confirmados_1") val confirmados1: Int,
        @SerializedName("incidencia") val incidencia: Int,
        @SerializedName("incidencia_categoria") val incidenciaCategoria: ArrayList<Int>,
        @SerializedName("incidencia_risco") val incidenciaRisco: String,
        @SerializedName("tendencia_incidencia") val tendenciaIncidencia: String,
        @SerializedName("tendencia_icategoria") val tendenciaCategoria: String,
        @SerializedName("tendencia_desc") val tendenciaDesc: String,
        @SerializedName("casos_14dias") val casos14Dias: Int,
        @SerializedName("ars") val ars: String,
        @SerializedName("distrito") val distrito: String,
        @SerializedName("dicofre") val dicofre: Int,
        @SerializedName("area") val area: Double,
        @SerializedName("population") val population: Int,
        @SerializedName("population_65_69") val population6569: Int,
        @SerializedName("population_70_74") val population7074: Int,
        @SerializedName("population_75_79") val population7579: Int,
        @SerializedName("population_80_84") val population8084: Int,
        @SerializedName("population_85_mais") val population85Mais: Int,
        @SerializedName("population_80_mais") val population80Mais: Int,
        @SerializedName("population_75_mais") val population75Mais: Int,
        @SerializedName("population_70_mais") val population70Mais: Int,
        @SerializedName("population_65_mais") val population65Mais: Int,
        @SerializedName("densidade_populacional") val densidadePopulacional: Double,
        @SerializedName("densidade_1") val densidade1: Double,
        @SerializedName("densidade_2") val densidade2: Double,
        @SerializedName("densidade_3") val densidade3: Double,
) {
}