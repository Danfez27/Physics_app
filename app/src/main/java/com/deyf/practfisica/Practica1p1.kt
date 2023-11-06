package com.deyf.practfisica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import java.nio.ByteBuffer

class Practica1p1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica1p1)
        val text1 = findViewById<TextView>(R.id.p1_txt1)
        val text2 = findViewById<TextView>(R.id.p1_txt2)
        val text3 = findViewById<TextView>(R.id.p1_txt3)
        val text4 = findViewById<TextView>(R.id.p1_txt4)
        val text5 = findViewById<TextView>(R.id.p1_txt5)

        var datos_nuevos =""
        var datos = ""
        var cont = 0
        var texto = ""

        // Inicia el temporizador

        fun startTimer(time: Long,interval:Long ) {
            val timer = object : CountDownTimer(time,interval) {
                override fun onTick(millisUntilFinished: Long) {

                    //Aquí va la acción que se va a repetir cada x tiempo
                    val buffer = ByteArray(1024)
                    MainActivity.m_bluetoothSocket?.inputStream?.read(buffer)
                    datos = ByteBuffer.wrap(buffer).double.toString()

                    if (datos != datos_nuevos){


                        if(cont==3){texto =""}

                        when (cont) {
                            3 -> texto =""
                            6 -> texto =""
                            9 -> texto =""
                            12 -> texto =""
                            15 -> texto =""
                        }
                        if (texto == "")
                            texto = datos
                        else
                            texto += "\n{$datos}"

                        datos_nuevos = datos
                        cont +=1
                    }

                    if (cont <4)
                        text1.text = texto
                    else if (cont <7)
                        text2.text = texto
                    else if (cont <10)
                        text3.text = texto
                    else if (cont <13)
                        text4.text = texto
                    else if (cont <16)
                        text5.text = texto
                }

                override fun onFinish() {
                    // Muestra un mensaje
                    Toast.makeText(this@Practica1p1, "El temporizador ha terminado", Toast.LENGTH_LONG).show()
                }
            }

            timer.start()
        }
        startTimer(1000*60*5,2000)








/*        val bluetoothReader = object : Thread() {
            override fun run() {
                while (true) {

                    // Recibir los datos Bluetooth

                }
            }
        }*/

/*        val bluetoothReader1 = object : Thread() {
            override fun run() {
                while (true) {

    // Recibir los datos Bluetooth
                    val buffer = ByteArray(9000)
                    m_bluetoothSocket?.inputStream?.read(buffer)
                    val datos = ByteBuffer.wrap(buffer).double
                    val datosFloat = datos.toFloat()
                    text2.text = datosFloat.toString()


// Detectar datos cada 500 milisegundos
                    try {
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }*/
    }
}