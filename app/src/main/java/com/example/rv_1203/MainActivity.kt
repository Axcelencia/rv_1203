package com.example.rv_1203

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        /*val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter_detalle_obj()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter*/
    }
}