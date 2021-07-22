package com.example.a58_navegador_con_webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   /*  explicacion de la necesidad del lateinit
    // string dato = null;
    // public void mostrarMensaje()
    {
        dato="hola";
    }
    esto que pasaba en java con el lateinit se arregla.
    */


    lateinit var textoPage:TextView
    lateinit var goButton:Button
    lateinit var vistaWeb:WebView
    lateinit var backButton:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textoPage=textWebPage
        goButton=goPageButton
        vistaWeb=webView
        backButton=backPageButton
        goButton.setOnClickListener {



            vistaWeb.loadUrl("https://" + textoPage.text.toString())
            vistaWeb.webViewClient= mostrarEnAplicaion()
        }
        backButton.setOnClickListener {

            vistaWeb.goBack()

        }
    }

    private  class mostrarEnAplicaion: WebViewClient() {

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            if (request != null) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    view?.loadUrl(request.url.toString())
                }
            }
            return true
        }

    }
}
