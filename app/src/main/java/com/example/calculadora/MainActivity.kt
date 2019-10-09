package com.example.calculadora

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("PLUGIN_WARNING")

class MainActivity : AppCompatActivity() {
    var signo: Char = ' '
    var reserva: Double = 0.0
    var compruebaIgual: Boolean = false
    var memoria: Double = 0.0
    var url: String= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            desactivarOperaciones()
        }

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            wbve_Web.webViewClient = object: WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    view?.loadUrl(url)

                    return true
                }
            }

            eitx_Buscador.setOnKeyListener(View.OnKeyListener {v, keyCode, event ->
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                    cargarUrl()

                    return@OnKeyListener true
                }
                return@OnKeyListener false
            })

            wbve_Web.loadUrl("https://www.google.com/")
        }
    }

    fun cargarUrl(){
        url = eitx_Buscador.text.toString()

        if(eitx_Buscador.text.toString().startsWith("https://")) {
            if(url.endsWith(".com") || url.endsWith(".es")) {
                wbve_Web.loadUrl(url)
            } else {
                wbve_Web.loadUrl("www.google.com/search?q=" + url + "&oq=" + url + "&aqs")
            }
        } else {
            if(url.endsWith(".com") || url.endsWith(".es")) {
                wbve_Web.loadUrl("https://" + url)
            } else {
                wbve_Web.loadUrl("https://www.google.com/search?q=" + url + "&oq=" + url + "&aqs")
            }
        }
    }

    fun numero(v: View) {
        when(v.id) {
            bt_1.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString() + "1")
                if(!bt_Igual.isClickable) activarOperaciones()
            }
            bt_2.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString() + "2")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_3.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString() + "3")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_4.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString() + "4")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_5.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString() + "5")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_6.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString() + "6")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_7.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString() + "7")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_8.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString()+ "8")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_9.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString()+ "9")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_0.id -> {
                if(compruebaIgual) {
                    eitx_Pantalla.setText("")
                    compruebaIgual = false
                }
                eitx_Pantalla.setText(eitx_Pantalla.text.toString() + "0")
                if(!bt_Suma.isClickable) activarOperaciones()
            }
            bt_Borrar.id -> {
                eitx_Pantalla.setText("")
                reserva = 0.0
                activarNumeros()
                desactivarOperaciones()
            }
        }
    }

    fun activarOperaciones() {
        bt_Suma.isClickable = true
        bt_Resta.isClickable = true
        bt_Multiplicacion.isClickable = true
        bt_Division.isClickable = true
        bt_Igual.isClickable = true
    }

    fun desactivarOperaciones() {
        bt_Suma.isClickable = false
        bt_Resta.isClickable = false
        bt_Multiplicacion.isClickable = false
        bt_Division.isClickable = false
        bt_Igual.isClickable = false
    }

    fun desactivarNumeros() {
        bt_1.isClickable = false
        bt_2.isClickable = false
        bt_3.isClickable = false
        bt_4.isClickable = false
        bt_5.isClickable = false
        bt_6.isClickable = false
        bt_7.isClickable = false
        bt_8.isClickable = false
        bt_9.isClickable = false
        bt_0.isClickable = false
    }

    fun activarNumeros() {
        bt_1.isClickable = true
        bt_2.isClickable = true
        bt_3.isClickable = true
        bt_4.isClickable = true
        bt_5.isClickable = true
        bt_6.isClickable = true
        bt_7.isClickable = true
        bt_8.isClickable = true
        bt_9.isClickable = true
        bt_0.isClickable = true
    }

    fun signo(v: View) {
        when(v.id) {
            bt_Suma.id -> {
                desactivarOperaciones()
                activarNumeros()
                comprobarSigno()
                signo = '+'
            }
            bt_Resta.id -> {
                desactivarOperaciones()
                activarNumeros()
                comprobarSigno()
                signo = '-'
            }
            bt_Multiplicacion.id -> {
                desactivarOperaciones()
                activarNumeros()
                comprobarSigno()
                signo = '*'
            }
            bt_Division.id -> {
                desactivarOperaciones()
                activarNumeros()
                comprobarSigno()
                signo = '/'
            }
            bt_Igual.id -> {
                bt_Igual.setClickable(false)
                comprobarSigno()
                eitx_Pantalla.setText(reserva.toString())
                reserva = 0.0
                signo = ' '
                compruebaIgual = true
                desactivarNumeros()
            }
        }
    }

    fun comprobarSigno() {
        when(signo) {
            '+' -> {
                reserva += eitx_Pantalla.text.toString().toDouble()
                eitx_Pantalla.setText("")
            }
            '-' -> {
                reserva -= eitx_Pantalla.text.toString().toDouble()
                eitx_Pantalla.setText("")
            }
            '*' -> {
                reserva *= eitx_Pantalla.text.toString().toDouble()
                eitx_Pantalla.setText("")
            }
            '/' -> {
                reserva /= eitx_Pantalla.text.toString().toDouble()
                eitx_Pantalla.setText("")
            }
            '=' -> {}
            else -> {
                reserva += eitx_Pantalla.text.toString().toDouble()
                eitx_Pantalla.setText("")
            }
        }
    }

    fun memoria(v: View) {
        when (v.id) {
            bt_BorrarMemoria.id ->  memoria = 0.0
            bt_SumarMemoria.id -> if(eitx_Pantalla.text.toString() != "") memoria += eitx_Pantalla.text.toString().toDouble()
            bt_Resta.id -> if(eitx_Pantalla.text.toString() != "") memoria -= eitx_Pantalla.text.toString().toDouble()
            bt_MostrarMemoria.id -> {
                eitx_Pantalla.setText(memoria.toString())
                desactivarNumeros()
                activarOperaciones()
            }
        }
    }
}