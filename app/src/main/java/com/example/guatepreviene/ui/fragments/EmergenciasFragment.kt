package com.example.guatepreviene.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.viewmodel.EmergenciasViewModel

class EmergenciasFragment : Fragment() {

    companion object {
        fun newInstance() = EmergenciasFragment()
    }

    private lateinit var viewModel: EmergenciasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.emergencias_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmergenciasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}