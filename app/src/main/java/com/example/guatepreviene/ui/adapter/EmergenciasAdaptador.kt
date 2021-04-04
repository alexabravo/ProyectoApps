package com.example.guatepreviene.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.models.Emergencias
import com.squareup.picasso.Picasso

class EmergenciasAdaptador(var element: ArrayList<Emergencias>, var contxt: Context) : BaseAdapter() {

    var diseño = contxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return element.size
    }

    override fun getItem(position: Int): Any {
        return element[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        if(vista == null) {
            vista = diseño.inflate(R.layout.item_emergencias, parent, false)
        }

        var emergencia_titulo = vista?.findViewById<TextView>(R.id.EmerTitle)
        var emergencia_numero = vista?.findViewById<TextView>(R.id.EmerNumero)
        var emergencia_imagen = vista?.findViewById<ImageView>(R.id.EmerView)

        emergencia_titulo?.text = element[position].titulo
        emergencia_numero?.text = element[position].telefono
        Picasso.get().load(element[position].imagen!!).into(emergencia_imagen)

        return vista!!

    }

}
