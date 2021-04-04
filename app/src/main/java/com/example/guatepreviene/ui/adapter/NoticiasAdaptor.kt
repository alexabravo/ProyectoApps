package com.example.guatepreviene.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.models.Noticias
import com.squareup.picasso.Picasso

class NoticiasAdaptor(var element: ArrayList<Noticias>, var contxt: Context) : BaseAdapter() {

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
        if (vista == null) {
            vista = diseño.inflate(R.layout.item_noticias, parent, false)
        }

        var noti_titulo = vista?.findViewById<TextView>(R.id.NotiTitle)
        var noti_imagen = vista?.findViewById<ImageView>(R.id.NotiView)
        var noti_categoria = vista?.findViewById<TextView>(R.id.NotiCategory)

        noti_titulo?.text = element[position].titulo
        noti_categoria?.text = element[position].categoria
        Picasso.get().load(element[position].imagen!!).into(noti_imagen)

        return vista!!

    }
}