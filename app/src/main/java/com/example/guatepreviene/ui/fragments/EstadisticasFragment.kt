package com.example.guatepreviene.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.api.EstadisticasApi
import com.example.guatepreviene.ui.viewmodel.EstadisticasViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class EstadisticasFragment : Fragment() {

    private lateinit var EstaviewModel: EstadisticasViewModel
    lateinit var recovered: TextView
    lateinit var confirmed: TextView
    lateinit var deaths: TextView
    lateinit var country: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.estadisticas_fragment, container, false)

        EstaviewModel =
            ViewModelProvider(this).get(EstadisticasViewModel::class.java)

        recovered = root.findViewById(R.id.txt_number_recovered)
        confirmed = root.findViewById(R.id.txt_number_confirmed)
        deaths = root.findViewById(R.id.txt_number_deaths)
        country = root.findViewById(R.id.txt_country)
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = Retrofit.Builder()
            .baseUrl("http://gtpreviene.researchmobile.co:3000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EstadisticasApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getStatistics()
                country.text = " ${response.country}"
                recovered.text = " ${response.recovered}"
                confirmed.text = "${response.confirmed}"
                deaths.text = "${response.deaths}"
            } catch (e: Exception) {
                Log.e("Estadisticas", "Error: ${e.message}")

            }
        }

    }

}