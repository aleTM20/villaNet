package villa.net.villanet.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import villa.net.villanet.R
import villa.net.villanet.adapters.TemperaturaAdapter
import villa.net.villanet.contract.TemperaturaContract
import villa.net.villanet.databinding.ActivityMainBinding
import villa.net.villanet.models.bean.Temperatura
import villa.net.villanet.presenters.TemperaturaPresenter

class MainActivity : AppCompatActivity(), TemperaturaContract.View {
    private lateinit var closeJobsPresenter: TemperaturaPresenter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        closeJobsPresenter = TemperaturaPresenter(this)
        closeJobsPresenter.onLoad()
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun onLoaded(listaTemperatura: List<Temperatura>) {
        
        binding.recyclerTemperatura.layoutManager = LinearLayoutManager(this)
        binding.recyclerTemperatura.adapter = TemperaturaAdapter(listaTemperatura)
    }
}