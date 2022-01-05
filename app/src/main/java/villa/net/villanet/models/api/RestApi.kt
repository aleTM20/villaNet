package villa.net.villanet.models.api

import io.reactivex.Observable
import retrofit2.http.*
import villa.net.villanet.models.bean.Temperatura

interface RestApi {

    @GET("app.php?cc=cc")
    fun getTemperatura(): Observable<List<Temperatura>>

}