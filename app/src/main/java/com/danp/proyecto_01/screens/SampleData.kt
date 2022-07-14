package com.danp.proyecto_01.screens

data class Message(
    val placa: String,
    val descripcion: String,
)

object SampleData {
    val autos = listOf(
        Message(
            "H22HHH",
            "El auto es de color verde y se encuentra dañado en la parte de la puerta delantera y tiene muchas imagenes en la pintura.",
        ),
        Message(
            "V78V52",
            "El auto es de color verde y se encuentra dañado en la parte de la puerta delantera y tiene muchas imagenes en la pintura.",
        ),
        Message(
            "GG5555",
            "El auto es de color verde y se encuentra dañado en la parte de la puerta delantera y tiene muchas imagenes en la pintura.",
        ),
        Message(
            "ELJ777",
            "El auto es de color verde y se encuentra dañado en la parte de la puerta delantera y tiene muchas imagenes en la pintura.",
        ),
        Message(
            "GGH58H",
            "El auto es de color verde y se encuentra dañado en la parte de la puerta delantera y tiene muchas imagenes en la pintura.",
        ),
    )
}


