package com.example.guatepreviene.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.viewmodel.NoticiasViewModel


class NoticiasFragment : Fragment() {

    companion object {
        fun newInstance() = NoticiasFragment()
    }

    private lateinit var viewModel: NoticiasViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.noticias_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NoticiasViewModel::class.java)
        // TODO: Use the ViewModel
    }

}