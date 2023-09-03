package com.example.calcjacqui

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private lateinit var botonCalcular: Button
    private lateinit var campoSueldo: EditText
    private lateinit var campoBonoDecreto: EditText
    private lateinit var campoHorasExtras: EditText
    private lateinit var campoCombo1: EditText
    private lateinit var campoCombo2: EditText
    private lateinit var campoCombo3: EditText
    private lateinit var campoProductos: EditText
    private lateinit var campoTotalClientas: EditText
    private lateinit var vistaTotalSueldo:TextView
    private lateinit var campoVistadesIgss:TextView
    private lateinit var campoVistaDescISR:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonCalcular = findViewById(R.id.botonCalcular)
        campoSueldo = findViewById(R.id.campoSueldo)
        campoBonoDecreto = findViewById(R.id.campoBonoDecreto)
        campoHorasExtras = findViewById(R.id.campoHorasExtras)
        campoCombo1 = findViewById(R.id.campoCombo1)
        campoCombo2 = findViewById(R.id.campoCombo2)
        campoCombo3 = findViewById(R.id.campoCombo3)
        campoProductos = findViewById(R.id.campoProductos)
        campoTotalClientas = findViewById(R.id.campoTotalClientas)
        vistaTotalSueldo = findViewById(R.id.vistaTotalSueldo)
        campoVistadesIgss = findViewById(R.id.campoVistadesIgss)
        campoVistaDescISR = findViewById(R.id.campoVistaDescISR)

        //inputdata to String

        val valsalario = campoSueldo.text.toString()
        val valbonoDec = campoBonoDecreto.text.toString()
        val valhoraEx = campoHorasExtras.text.toString()
        val valbonoUno = campoCombo1.text.toString()
        val valbonoDos = campoCombo2.text.toString()
        val valbonoTres = campoCombo3.text.toString()
        val valbonoProductos = campoProductos.text.toString()
        val valtotalClientas = campoTotalClientas.text.toString()

        try {
            val input = campoSueldo.text.toString()
            if (input.isNotEmpty()) {
                val number = Integer.parseInt(input)
                // Rest of the code using the number
            } else {
                // Handle the case when the input is empty
            }
        } catch (e: NumberFormatException) {
            // Handle the case when the input string is not a valid integer
        }

        botonCalcular.setOnClickListener{


            //String to Integer
            var salario= valsalario.toDouble()
            var bono = valbonoDec.toDouble()
            var horasX = valhoraEx.toDouble()
            var comboUno = valbonoUno.toDouble()
            var comboDos = valbonoDos.toDouble()
            var comboTres = valbonoTres.toDouble()
            var itemsTotal = valbonoProductos.toDouble()
            var clientasAtendidas = valtotalClientas.toDouble()

            /*try {
                val number = Integer.parseInt(valsalario)
                // Perform operations with the parsed number
            } catch (e: NumberFormatException) {
                // Handle the exception here
                // You can display an error message to the user or perform any other necessary actions
                Log.e(TAG, "Invalid input: $valsalario")
            }

             */

            //calcs
            val sumaSueldo = salario + bono
            val horaExtra = horasX * 1.25
            val cmb1 = comboUno * 6.64
            val cmb2 =comboDos * 15
            val cmb3 = comboTres * 9.42
            val totalCombos =  cmb1+cmb2+cmb3
            val items= itemsTotal * 0.02
            val clientesTotal = clientasAtendidas * 0.5
            val ttlSalario = sumaSueldo+horaExtra
            val extras = items + clientesTotal
            val granTotal = ttlSalario +extras
            val iIgss = salario * 0.0483
            val iIsr = (sumaSueldo + totalCombos + items + clientesTotal)*0.05
            val descuentos = iIgss + iIsr
            val recibirNeto = granTotal - descuentos

            // Integer to String so can be set on the TextView fields

            val liquido: String = recibirNeto.toString()
            val calcIgss: String = iIgss.toString()
            val calcIsr: String = iIsr.toString()
            vistaTotalSueldo.text = liquido
            campoVistadesIgss.text = calcIgss
            campoVistaDescISR.text = calcIsr



        }

    }

}