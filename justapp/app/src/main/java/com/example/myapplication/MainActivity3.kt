package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    private lateinit var Refresh:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        Refresh=findViewById(R.id.m3btn)
        Refresh.setOnClickListener {
            Toast.makeText(this,"Coming Soon",Toast.LENGTH_LONG).show()
        }
    }
}