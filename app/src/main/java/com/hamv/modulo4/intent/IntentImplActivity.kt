package com.hamv.modulo4.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.hamv.modulo4.R

class IntentImplActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        //Enlaza la vista con esta clase activity
        setContentView(R.layout.activity_intent_impl);
        val sendButton = findViewById<Button>(R.id.sendButton);
        sendButton.setOnClickListener{
            //Toast.makeText(this, "Le diste click al boton enviar", Toast.LENGTH_SHORT).show();
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:");
                putExtra(Intent.EXTRA_SUBJECT, "Avíso urgente");
                putExtra(Intent.EXTRA_TEXT, "Esto es una prueba de Intent implícito para enviar");
            }
            startActivity(Intent.createChooser(emailIntent,"Enviar email"));
            //Envio de mensaje largo o corto.
            //Toast.makeText(this, "Le diste click al boton enviar", Toast.LENGTH_SHORT).show();
        };
        //crear referencia con el segundo boton
        val sendUrlButton = findViewById<Button>(R.id.sendUrlButton);
        sendUrlButton.setOnClickListener {
            // Generar un nuevo intent implicito
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            startActivity(urlIntent);
            //Alternativa de toast para mostrar mensajes
            //Snackbar.make(sendUrlButton, "Prueba snackBar", 5000).show();
        }
    }
}