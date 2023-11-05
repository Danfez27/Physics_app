package com.deyf.practfisica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.deyf.practfisica.MainActivity.Companion.m_bluetoothSocket
import java.nio.ByteBuffer

class practica1p1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica1p1)
/*
        val text1 = findViewById<TextView>(R.id.txt1)
        val text2 = findViewById<TextView>(R.id.txt2)


        val bluetoothReader = object : Thread() {
            override fun run() {
                while (true) {

                    // Recibir los datos Bluetooth
                    val buffer = ByteArray(9000)
                    MainActivity.m_bluetoothSocket?.inputStream?.read(buffer)
                    val datos = ByteBuffer.wrap(buffer).double
                    text1.text = datos.toString()
                    // Detectar datos cada 500 milisegundos
                    try {
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }

        val bluetoothReader1 = object : Thread() {
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