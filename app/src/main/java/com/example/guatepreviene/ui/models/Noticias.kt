package com.example.guatepreviene.ui.models

import java.io.Serializable

class Noticias: Serializable {

    var titulo: String
    var categoria: String
    var imagen: String
    var descripcion: String

    constructor(titulo: String, categoria: String, imagen: String, descripcion: String) {
        this.titulo = titulo
        this.categoria = categoria
        this.imagen = imagen
        var descAct: String = descripcion.replace("<p>", "")
        descAct = descAct.replace("<br>", "\n")
        descAct = descAct.replace("<br/>", "\n")
        descAct = descAct.replace("</p>", "")
        this.descripcion = descAct
    }
}