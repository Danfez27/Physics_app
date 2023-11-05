package com.deyf.practfisica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import java.nio.ByteBuffer

class Practica1p2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica1p2)

        val text1 = findViewById<TextView>(R.id.p2_txt1)
        val text2 = findViewById<TextView>(R.id.p2_txt2)
        val text3 = findViewById<TextView>(R.id.p2_txt3)
        val text4 = findViewById<TextView>(R.id.p2_txt4)
        val text5 = findViewById<TextView>(R.id.p2_txt5)
        var datos_nuevos =""
        var datos: String
        var cont = 0
        var texto = ""
        // Inicia el temporizador

        fun startTimer(interval: Long) {
            val timer = object : CountDownTimer(interval, interval) {
                override fun onTick(millisUntilFinished: Long) {
                    //Aquí va la acción que se va a repetir cada x tiempo
                    val buffer = ByteArray(9000)
                    MainActivity.m_bluetoothSocket?.inputStream?.read(buffer)
                    datos = ByteBuffer.wrap(buffer).double.toString()

                    if (datos != datos_nuevos)

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

                    when{
                        cont<4 -> text1.text = texto
                        cont<7 -> text2.text = texto
                        cont<10 -> text3.text = texto
                        cont<13 -> text4.text = texto
                        cont<16 -> text5.text = texto
                   }
/*                     if (cont <4)
                           text1.text = texto
                       else if (cont <7)
                            text2.text = texto
                       else if (cont <10)
                            text3.text = texto
                       else if (cont <13)
                            text4.text = texto
                       else if (cont <16)
                            text5.text = texto*/
                }

                override fun onFinish() {
                    // Muestra un mensaje
                    Toast.makeText(this@Practica1p2, "El temporizador ha terminado", Toast.LENGTH_LONG).show()
                }
            }

            timer.start()
        }
        startTimer(500)
    }
}