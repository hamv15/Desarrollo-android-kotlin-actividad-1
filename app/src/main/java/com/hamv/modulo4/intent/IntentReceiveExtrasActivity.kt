package com.hamv.modulo4.intent

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.hamv.modulo4.R

class IntentReceiveExtrasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_receive_extras);
        //Obtener la información que nos están enviando
        val name = intent?.getStringExtra("EXTRA_NAME");
        val lastName = intent.getStringExtra("EXTRA_LAST_NAME");
        val age = intent.getIntExtra("EXTRA_AGE", 0);
        val isMarried = intent.getBooleanExtra("EXTRA_IS_MARRIED", false);
        val persona =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("EXTRA_PERSON", Persona::class.java);
        }else{
            intent.getSerializableExtra("EXTRA_PERSON") as Persona;
        }

        //Obtener los elementos de la vista que van a mostrar los datos
        val labelName = findViewById<TextView>(R.id.labelText);
        labelName.text = "Mi nombre es: $name $lastName, mi edad es: $age y ${if (isMarried) "estoy casado" else "no estoy casado"}, ${persona?.alias ?: "No hay alias"}";

        //Obtener referencia del botón de regresar
        val returnBtn = findViewById<Button>(R.id.returnButton);



        returnBtn.setOnClickListener {
            //Creación del intent
            val resultIntent = Intent().apply {
            putExtra("EXTRA_IS_VALID", true);
            }
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }
}