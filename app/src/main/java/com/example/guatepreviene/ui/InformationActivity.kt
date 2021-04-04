package com.example.guatepreviene.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.guatepreviene.R
import com.example.guatepreviene.ui.models.Noticias
import com.squareup.picasso.Picasso

class InformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        var modalNews: Noticias = intent.getSerializableExtra("data") as Noticias

        var title: TextView = findViewById(R.id.NotiTitle)
        title.text = "${modalNews.titulo}"

        var detalle: TextView = findViewById(R.id.NotiDetail)
        detalle.text = "${modalNews.descripcion}"

        var image: ImageView = findViewById(R.id.NotiView)
        Picasso.get().load(modalNews.imagen).into(image)
    }
}



