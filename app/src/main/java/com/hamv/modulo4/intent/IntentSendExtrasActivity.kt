package com.hamv.modulo4.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    //Definir listenner
    private val resultRegister = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            Toast.makeText(this, "resultCode = ${result.resultCode}, es valido?: ${result.data?.getBooleanExtra("EXTRA_IS_VALID", false)}", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show();
        }
    }
}