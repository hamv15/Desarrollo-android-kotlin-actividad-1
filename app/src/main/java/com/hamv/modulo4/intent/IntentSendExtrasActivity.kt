package com.hamv.modulo4.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.hamv.modulo4.R

class IntentSendExtrasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_send_extras);
        //Obtención de referencia del boton
        val sendExtrasBtn = findViewById<Button>(R.id.sendExtrasButton);
        sendExtrasBtn.setOnClickListener {
            val sendIntent = Intent(this, IntentReceiveExtrasActivity::class.java).apply {
                //Estamos dentro del inten se puede ingresar las llaves
                putExtra("EXTRA_NAME", "Hugo");
                putExtra("EXTRA_LAST_NAME", "Meza");
                putExtra("EXTRA_AGE", 25);
                putExtra("EXTRA_IS_MARRIED", false);
                putExtra("EXTRA_AUTO", Auto("Ford", "EcoSport", 2018, 38200.2,true))
            };
            //pasarle los parámetros
                //Forma imple una por una
            //sendIntent.putExtra("KEY_1", "String 1");

            //startActivity(sendIntent);//No espera un resultado
            resultRegister.launch(sendIntent); //Lanza escchador para esperar respuesta del activity
        }
        //crear referencia con el segundo boton
        val sendUrlButton = findViewById<Button>(R.id.sendUrlButton);
        sendUrlButton.setOnClickListener {
            // Generar un nuevo intent implicito
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ford.mx"));
            startActivity(urlIntent);
            //Alternativa de toast para mostrar mensajes
            //Snackbar.make(sendUrlButton, "Prueba snackBar", 5000).show();
        }
    }
    //Definir listenner
    private val resultRegister = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            Toast.makeText(this, "resultCode = ${result.resultCode}, es valido?: ${result.data?.getBooleanExtra("EXTRA_IS_VALID", false)}", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show();
        }
    }

    //métodos del ciclo de vida
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Estoy en onStart", Toast.LENGTH_SHORT).show()
        Log.e("CICLO_VIDA", "estoy en onStart")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Estoy en onResume", Toast.LENGTH_SHORT).show()
        Log.e("CICLO_VIDA", "estoy en onResume")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Estoy en onPause", Toast.LENGTH_SHORT).show()
        Log.e("CICLO_VIDA", "Estoy en onPause")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Estoy en onStop", Toast.LENGTH_SHORT).show()
        Log.e("CICLO_VIDA", "Estoy en onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Estoy en onRestart", Toast.LENGTH_SHORT).show()
        Log.e("CICLO_VIDA", "Estoy en onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Estoy en onDestroy", Toast.LENGTH_SHORT).show()
        Log.e("CICLO_VIDA", "Estoy en onDestroy")
    }
}