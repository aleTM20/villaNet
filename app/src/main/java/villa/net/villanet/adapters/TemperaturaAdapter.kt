package villa.net.villanet.adapters

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import villa.net.villanet.R
import villa.net.villanet.databinding.CardTemperaturaBinding
import villa.net.villanet.models.bean.Temperatura

class TemperaturaAdapter(private val listaTemperatura: List<Temperatura>) :
    RecyclerView.Adapter<TemperaturaAdapter.TemperaturaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperaturaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_temperatura, parent, false)
        return TemperaturaHolder(view)
    }

    override fun onBindViewHolder(holder: TemperaturaHolder, position: Int) {
        holder.render(listaTemperatura[position])
    }

    override fun getItemCount(): Int = listaTemperatura.size

    class TemperaturaHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CardTemperaturaBinding.bind(view)
        fun render(temperatura: Temperatura) {
            if(temperatura.sensor != null){
                binding.tvSensor.text = temperatura.sensor
            }else{
                binding.tvSensor.text = "NO SE ENCONTRO SENSOR"
            }
            binding.tvFecha.text = temperatura.fecha

            if(temperatura.sensor != null){
                binding.tvSensor.text = temperatura.sensor
            }else{
                binding.tvSensor.text = "NO SE ENCONTRO SENSOR"
            }

            if(temperatura.temperatura != null){
                binding.tvTemperatura.text = temperatura.temperatura
                binding.tvTemperatura.setBackgroundColor(R.drawable.border_round_pill)
            }else{
                binding.tvTemperatura.text = "-----"
                binding.tvTemperatura.setBackgroundColor(R.drawable.border_round_pill_danger)
            }
        }
    }

}