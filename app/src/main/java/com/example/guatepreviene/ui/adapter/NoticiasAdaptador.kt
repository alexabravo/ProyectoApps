package com.example.guatepreviene.ui.adapter

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.models.Noticias
import com.squareup.picasso.Picasso

class NoticiasAdaptador(var element: ArrayList<Noticias>, var context: Context) :
    BaseAdapter() {

    var diseño = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

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
        var muestra = convertView
        if(muestra == null) {
            muestra = diseño.inflate(R.layout.item_noticias, parent, false)
        }

        var noti_titulo = muestra?.findViewById<TextView>(R.id.txt_title)
        var noti_imagen = muestra?.findViewById<ImageView>(R.id.img_news)
        var noti_categoria = muestra?.findViewById<TextView>(R.id.txt_category)

        noti_titulo?.text = element[position].titulo
        noti_categoria?.text = element[position].categoria
        Picasso.get().load(element[position].imagen!!).into(noti_imagen)

        return muestra!!
    }

}
