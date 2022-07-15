package com.danp.proyecto_01.screens

data class Message(
    val nombre: String,
    val descripcion: String,
    val dificultad: String,
)

object SampleData {
    val recetas = listOf(
        Message(
            "Receta de Baleadas hondureñas",
            "\t4 trotillas de harina,2 tazas de frijoles negros cocidos,2 aguacates,150 gramos de queso rallado,4 cucharadas soperas de crema agria",
            "Baja",
            ),
        Message(
            "Receta de Masa para empanadas fritas\t",
            "3 tazas de harina de trigo (420 gramos),1 pizca de sal,80 gramos de manteca (o mantequilla),1 cucharadita de polvo de hornear,1 tarro de leche o agua caliente,300 mililitros de aceite de oliva o girasol,1 cuenco de relleno al gusto (pino, queso u otro)",
            "Alta",
            ),
        Message(
            "Receta de Farofa brasileña\t",
            "1 cebolla grande,1 chorro de aceite,2 cucharadas soperas de mantequilla,1 taza de harina de yuca o tapioca especiada\n",
            "Baja",

            ),
        Message(
            "Receta de Tarta de choclo\t",
            "200 gramos de harina,1 pizca de sal,1 pizca de pimienta,1 pizca de orégano,3 cucharadas soperas de aceite,1 chorro de agua,2 mazorcas de maíz,1 cebolla,2 cucharadas soperas de azúcar,1 pizca de sal,200 gramos de queso mozzarella,100 gramos de queso parmesano\n",
            "Media",

            ),
        Message(
            "Receta de Ceviche de pota\t",
            "1 kilogramo de pota,1 ají rocoto,2 cebollas moradas,2 limones,Cilantro al gusto,2 Choclos (mazorcas de maíz fresco),Sal,Pimienta,1 cucharada postre de pasta de ají molido\n",
            "Alta",

            ),
        Message(
            "Receta de Brochetas de pollo a la plancha\t",
            "2 pechugas de pollo,2 cebollas,2 pimientos verdes,1 Pimiento rojos,1 chorro de Aceite oliva virgen extra,1 pizca de Sal,1 pizca de Pimienta negra molida",
            "Baja",

            ),
        Message(
            "Receta de Quesadillas de pollo y queso al horno\t",
            "2 tortillas de maíz grandes,250 gramos de pechuga de pollo en lonchas (utilizo un paquete que trae 12 lonchas),6 lonchas de queso,1 chorro de Salsa picante con curry y tomate,1 puñado de queso rallado,1 puñado de cebolla frita\n",
            "Media",

            ),
        Message(
            "Receta de Sándwich de pollo, jamón y queso\t",
            "3 filetes de pechuga de pollo,4 lonchas de jamón de York,100 gramos de lechuga,8 lonchas de queso,6 rebanadas de pan de molde\n",
            "Alta",

            ),
        Message(
            "Receta de Tarta de cebolla y queso\t",
            "1 kilogramo de cebolla,queso al gusto,60 gramos de queso rallado,1 trozo de jengibre,1 manojo de Perejil,3 dientes de Ajo,1 lámina de Masa de hojaldre,1 chorro de Aceite de oliva,1 pizca de Sal,1 Huevo batido\n",
            "Media",

            ),
        Message(
            "Receta de Mantequilla de maní sin azúcar\t",
            "100 gramos de Cacahuetes tostados sin cáscara,1 pizca de Sal\n",
            "Baja",

            ),

    )
}


