package villa.net.villanet.contract

import villa.net.villanet.models.bean.Temperatura

interface TemperaturaContract {
    interface View {
        fun onError(error: String)
        fun onLoaded(listaTemperatura: List<Temperatura>)
    }

    interface Presenter {
        fun onError(error: Throwable)
        fun onLoad()
        fun onLoaded(listaTemperatura: List<Temperatura>)
        fun onDestroy()
    }
}