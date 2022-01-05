package villa.net.villanet.presenters

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import villa.net.villanet.contract.TemperaturaContract
import villa.net.villanet.models.api.RestApi
import villa.net.villanet.models.api.ServiceBuilder
import villa.net.villanet.models.bean.Temperatura
import java.net.SocketTimeoutException

class TemperaturaPresenter (private var temperaturaView: TemperaturaContract.View?) :
    TemperaturaContract.Presenter {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onLoad() {
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        compositeDisposable.add(
            retrofit.getTemperatura()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoaded, this::onError)
        )
    }

    override fun onLoaded(listaTemperatura: List<Temperatura>) {
        temperaturaView?.onLoaded(listaTemperatura)
    }

    override fun onError(error: Throwable) {
        Log.e("Error", error.toString())
        if (error is HttpException) {
            val exception = error as HttpException
//            Similar a un switch case
            when {
                exception.code() == 400 -> {
                    temperaturaView?.onError("Petición erronea")
                }
                exception.code() == 403 -> {
                    temperaturaView?.onError("Error desconocido, intentalo de nuevo.")
                    Log.e("Error 403", "Error desconocido, intentalo de nuevo.")
                }
                else -> {
                    Log.e("Error code", "--> ${exception.code()}")
                    temperaturaView?.onError("Error code, ${exception.code()}.")
                }
            }
        } else if (error is SocketTimeoutException) {
            temperaturaView?.onError("No hay conexión con el servidor")
        }
    }

    override fun onDestroy() {
        temperaturaView = null
    }
}