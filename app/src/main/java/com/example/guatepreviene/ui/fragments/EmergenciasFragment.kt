package com.example.guatepreviene.ui.fragments

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.adapter.EmergenciasAdaptador
import com.example.guatepreviene.ui.api.EmergenciasApi
import com.example.guatepreviene.ui.models.Emergencias
import com.example.guatepreviene.ui.viewmodel.EmergenciasViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EmergenciasFragment : Fragment() {


    private lateinit var EmerviewModel: EmergenciasViewModel
    private var tele_list = ArrayList<Emergencias>()
    private  lateinit var grid: GridView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        EmerviewModel =
                ViewModelProvider(this).get(EmergenciasViewModel::class.java)
        val root = inflater.inflate(R.layout.emergencias_fragment, container, false)
        grid = root.findViewById(R.id.gridView) as GridView
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = Retrofit.Builder()
                .baseUrl("http://gtpreviene.researchmobile.co:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EmergenciasApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getPhones()
                for (i in response.data) {
                    tele_list.add(Emergencias(i.title, i.phone, i.icon))
                }
                requireActivity().runOnUiThread {
                    renderGrid(tele_list)
                }
            } catch (e: Exception) {
                Log.e("Main", "Error: ${e.message}")
            }
        }
    }

    private fun renderGrid(listaTelefonos: ArrayList<Emergencias>) {
        var emergencias_adaptador = EmergenciasAdaptador(listaTelefonos, requireActivity())

        grid.adapter = emergencias_adaptador

        grid.setOnItemClickListener { arg0, arg1, position, arg3 ->
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${tele_list[position].telefono}")
            startActivity(intent)
            true
        }
    }


}

