package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realtimecrudadmin.R
import com.example.realtimecrudadmin.databinding.ActivityArchivoReportesBinding

class ArchivoReportes : AppCompatActivity() {

    private lateinit var binding:ActivityArchivoReportesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArchivoReportesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconoBackAr.setOnClickListener{
            val intent = Intent(this,HomeUser::class.java)
            startActivity(intent)
        }

        binding.btnPerdido.setOnClickListener{
            val intent = Intent(this,Lista_CVOP::class.java)
            startActivity(intent)
        }

    }


}