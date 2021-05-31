package pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.data.remote.responses

import com.google.gson.annotations.SerializedName
import pt.ulusofona.ecati.deisi.licenciatura.cm2021.grupo2.R
import java.io.Serializable
import java.util.*

data class DadosCovidResponse(@SerializedName("data") var data: String,
                              @SerializedName("data_dados") var dataDados: String,
                              @SerializedName("confirmados") var confirmados: Int,
                              @SerializedName("confirmados_arsnorte") var confirmadosNorte: Int,
                              @SerializedName("confirmados_arscentro") var confirmadosCentro: Int,
                              @SerializedName("confirmados_arslvt") var confirmadosLvt: Int,
                              @SerializedName("confirmados_arsalentejo") var confirmadosAlentejo: Int,
                              @SerializedName("confirmados_arsalgarve") var confirmadosAlgarve: Int,
                              @SerializedName("confirmados_acores") var confirmadosAcores: Int,
                              @SerializedName("confirmados_madeira") var confirmadosMadeira: Int,
                              @SerializedName("confirmados_estrangeiro") var confirmadosEstrangeiro: Int,
                              @SerializedName("confirmados_novos") var confirmadosNovos: Int,
                              @SerializedName("recuperados") var recuperados: Int,
                              @SerializedName("obitos") var obitos: Int,
                              @SerializedName("internados") var internados: Double,
                              @SerializedName("internados_uci") var internadosUci: Double,
                              @SerializedName("vigilancia") var vigilancia: Double,
                              @SerializedName("confirmados_0_9_f") var confirmados09f: Double,
                              @SerializedName("confirmados_0_9_m") var confirmados09m: Double,
                              @SerializedName("confirmados_10_19_f") var confirmados1019f: Double,
                              @SerializedName("confirmados_10_19_m") var confirmados1019m: Double,
                              @SerializedName("confirmados_20_29_f") var confirmados2029f: Double,
                              @SerializedName("confirmados_20_29_m") var confirmados2029m: Double,
                              @SerializedName("confirmados_30_39_f") var confirmados3039f: Double,
                              @SerializedName("confirmados_30_39_m") var confirmados3039m: Double,
                              @SerializedName("confirmados_40_49_f") var confirmados4049f: Double,
                              @SerializedName("confirmados_40_49_m") var confirmados4049m: Double,
                              @SerializedName("confirmados_50_59_f") var confirmados5059f: Double,
                              @SerializedName("confirmados_50_59_m") var confirmados5059m: Double,
                              @SerializedName("confirmados_60_69_f") var confirmados6069f: Double,
                              @SerializedName("confirmados_60_69_m") var confirmados6069m: Double,
                              @SerializedName("confirmados_70_79_f") var confirmados7079f: Double,
                              @SerializedName("confirmados_70_79_m") var confirmados7079m: Double,
                              @SerializedName("confirmados_80_plus_f") var confirmados80PlusF: Double,
                              @SerializedName("confirmados_80_plus_m") var confirmados80PlusM: Double,
                              @SerializedName("ativos") var ativos: Double,
                              @SerializedName("rt_nacional") var rtNacional: Double,
                              @SerializedName("rt_continente") var rtContinente: Double) {

}