package com.hamv.modulo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hamv.modulo4.intent.IntentImplActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("CICLO_VIDA", "estoy en onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("CICLO_VIDA", "estoy en onStart")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Esto es un toast", Toast.LENGTH_SHORT).show()
        Log.e("CICLO_VIDA", "estoy en onResume")
        //declaración de intent explicito
        var intent = Intent(this, IntentImplActivity::class.java);
        startActivity(intent);
    }

    override fun onPause() {
        super.onPause()
        Log.e("CICLO_VIDA", "estoy en onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("CICLO_VIDA", "estoy en onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("CICLO_VIDA", "estoy en onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("CICLO_VIDA", "estoy en onDestroy")
    }
}