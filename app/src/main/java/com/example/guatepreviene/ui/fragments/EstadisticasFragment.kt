package com.example.guatepreviene.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.viewmodel.EstadisticasViewModel

class EstadisticasFragment : Fragment() {

    companion object {
        fun newInstance() = EstadisticasFragment()
    }

    private lateinit var viewModel: EstadisticasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.estadisticas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EstadisticasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}