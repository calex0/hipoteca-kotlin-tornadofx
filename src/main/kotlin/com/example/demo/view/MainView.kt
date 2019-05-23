package com.example.demo.view

import tornadofx.*
import javafx.scene.control.Alert
import javafx.scene.control.TextField
import javafx.beans.property.SimpleStringProperty
//FUNCIONA como yo quería
//comprueba campos para evitar lanzamiento de excepciones
//mié abr 10 12:42:00 2019

class MainView : View("Calcula cuota hipoteca") {

    fun calculoCuota(capital: Double, interes: Double, anos: Double): Double {
        var inter: Double = interes / 12
        val plazo: Double = anos * 12
        val a: Double = 1 + inter / 100
        val b: Double = Math.pow(a, -plazo)
        var cuota: Double = capital * inter / (100 * (1 - b))
        cuota = Math.round(cuota).toDouble()

        return cuota
    }

    var capital2: TextField by singleAssign()
    var interes2: TextField by singleAssign()
    var anos2: TextField by singleAssign()

    var cuota2: Double = 0.0

    var res: Boolean = false


    override val root = form {

        fieldset {

            label("Cuota hipoteca")

            field("Capital") {
                capital2 = textfield()
            }
            field("Interés") {
                interes2 = textfield()
            }
            field("Años") {
                anos2 = textfield()
            }

            button("Calcular cuota").setOnAction {

//si hay campos vacios o strings en vez de números salta alert indicando error
                res = (capital2.text.toString() == "") || (interes2.text.toString() == "") || (anos2.text.toString() == "") || !(capital2.text.toString().matches("-?\\d+(\\.\\d+)?".toRegex()))|| !(interes2.text.toString().matches("-?\\d+(\\.\\d+)?".toRegex()))|| !(anos2.text.toString().matches("-?\\d+(\\.\\d+)?".toRegex()))

                if (res == true) {alert(Alert.AlertType.INFORMATION, "Error, campos obligatorios")}
                else {
                    cuota2 = calculoCuota(capital2.text.toDouble(), interes2.text.toDouble(), anos2.text.toDouble())

                    alert(Alert.AlertType.INFORMATION, cuota2.toString())
                }
            }
        }

    }
}



