package com.example.guatepreviene.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.viewmodel.MapaViewModel

class MapaFragment : Fragment() {

    companion object {
        fun newInstance() = MapaFragment()
    }

    private lateinit var viewModel: MapaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.mapa_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MapaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}