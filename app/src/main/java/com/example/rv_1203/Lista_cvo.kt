package com.example.rv_1203

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/*
* Activity correspondiente a la pantalla que lista todos los objetos perdidos
* cvo = CardView Object
* */
class Lista_cvo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_lista_cvo)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCVP)
        val adapter = CustomAdapterCVO()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}