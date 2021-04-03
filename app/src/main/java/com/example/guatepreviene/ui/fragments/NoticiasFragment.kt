package com.example.guatepreviene.ui.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.MainActivity2
import com.example.guatepreviene.ui.adapter.NoticiasAdaptador
import com.example.guatepreviene.ui.api.NoticiasApi
import com.example.guatepreviene.ui.models.Noticias
import com.example.guatepreviene.ui.viewmodel.NoticiasViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NoticiasFragment : Fragment() {

    private lateinit var NotiviewModel: NoticiasViewModel
    private var noti_lista = ArrayList<Noticias>()
    private lateinit var grid_view: GridView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        NotiviewModel = ViewModelProvider(this).get(NoticiasViewModel::class.java)

        val root = inflater.inflate(R.layout.noticias_fragment, container, false)
        grid_view = root.findViewById(R.id.gridView) as GridView
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = Retrofit.Builder()
            .baseUrl("http://gtpreviene.researchmobile.co:3000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NoticiasApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getNews()
                for (i in response) {
                    noti_lista.add(
                        Noticias(
                            i.title,
                            i.name,
                            i.start.split("T")[0],
                            i.image,
                            i.detail
                        )
                    )
                }
                requireActivity().runOnUiThread {
                    renderGrid(noti_lista)
                }
            } catch (e: Exception) {
                Log.e("Main", "Error: ${e.message}")
            }

        }
    }

    private fun renderGrid(notiLista: ArrayList<Noticias>) {
        var notiAdapt = NoticiasAdaptador(notiLista, requireActivity())

        grid_view.adapter = notiAdapt

        grid_view.setOnItemClickListener { arg0, arg1, position, arg3 ->
            var intent = Intent(requireActivity(), MainActivity2::class.java)
            intent.putExtra("data", noti_lista[position])
            startActivity(intent)
        }
    }
}



