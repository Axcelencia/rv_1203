package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realtimecrudadmin.R
import com.example.realtimecrudadmin.R.id.recyclerViewDOP
import com.example.realtimecrudadmin.databinding.ActivityDetalleOpBinding

class DetalleOP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_detalle_op)

        val recyclerView = findViewById<RecyclerView>(recyclerViewDOP)
        val adapter = CustomAdapterDOP()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}