package com.example.practica17

import android.widget.ImageView
import java.io.Serializable

class Alumno : Serializable {
    var Nombre : String=""
    var Apellidos : String=""
    var DNI : String =""
    var idimage : Int =0
    var foto = false

    constructor() {


    }

    constructor(Nombre: String, Apellidos: String, DNI: String, idimage : Int) {
        this.Nombre =    Nombre
        this.Apellidos = Apellidos
        this.DNI = DNI
        this.idimage = idimage
        this.foto = false
    }

    constructor(Nombre: String, ImageId: Int) {
        this.Nombre = Nombre
        this.idimage  = ImageId
        this.foto= true
    }

    override fun toString(): String {
        return "$Nombre"
    }

}