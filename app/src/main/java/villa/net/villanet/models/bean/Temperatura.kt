package villa.net.villanet.models.bean

import com.google.gson.annotations.SerializedName

data class Temperatura(
    @SerializedName("pk_station") val pkStation: Int?,
    @SerializedName("sensor") val sensor: String?,
    @SerializedName("temperatura") val temperatura: String?,
    @SerializedName("fecha") val fecha: String?
)
