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
        //Obtener las referencias de los textViews que se utilizarán para mostrar los datos
        val textPersona = findViewById<TextView>(R.id.labelText);
        val textAuto = findViewById<TextView>(R.id.datosAuto);

        //Obtener la información que nos están enviando
        val name = intent?.getStringExtra("EXTRA_NAME");
        val lastName = intent.getStringExtra("EXTRA_LAST_NAME");
        val age = intent.getIntExtra("EXTRA_AGE", 0);
        val isMarried = intent.getBooleanExtra("EXTRA_IS_MARRIED", false);
        val auto =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("EXTRA_AUTO", Auto::class.java);
        }else{
            intent.getSerializableExtra("EXTRA_AUTO") as Auto;
        }

        //Mostrar los datos en su textView correspondiente
        textPersona.text = "Nombre del propietario: $name $lastName, Edad: $age, Es casado: ${if (isMarried) "Si" else "No"}";
        textAuto.text = "Ensanbladora: ${auto?.marca ?: "No hay dato"}, Modelo: ${auto?.modelo}, Año: ${auto?.year}, Kilometraje: ${auto?.km}, Estatus: ${if (auto?.activo == true) "Activo" else "Inactivo"}"

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