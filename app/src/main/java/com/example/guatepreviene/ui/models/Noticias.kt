package com.example.guatepreviene.ui.models

import java.io.Serializable

class Noticias: Serializable {

    var titulo: String
    var categoria: String
    var fecha: String
    var imagen: String
    var descripcion: String

    constructor(titulo: String, categoria: String, fecha: String, imagen: String, descripcion: String) {
        this.titulo = titulo
        this.categoria = categoria
        this.fecha = fecha
        this.imagen = imagen
        var nueva_desc: String = descripcion.replace("<p>", "")
        nueva_desc = nueva_desc.replace("<br>", "\n")
        nueva_desc = nueva_desc.replace("<br/>", "\n")
        nueva_desc = nueva_desc.replace("</p>", "")
        this.descripcion = nueva_desc
    }
}