package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realtimecrudadmin.R
import com.example.realtimecrudadmin.R.id.recyclerViewCVOP
import com.example.realtimecrudadmin.databinding.ActivityListaCvopBinding

private lateinit var binding : ActivityListaCvopBinding
class Lista_CVOP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        binding = ActivityListaCvopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = findViewById<RecyclerView>(recyclerViewCVOP)
        val adapter = CustomAdapterCVOP()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        binding.textViewCVP.setOnClickListener{
            intent = Intent(this,DetalleOP::class.java)
            startActivity(intent)
        }

        binding.cvopIconBack.setOnClickListener{
            intent = Intent(this,ArchivoReportes::class.java)
            startActivity(intent)
        }
    }
}


