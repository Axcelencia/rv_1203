package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realtimecrudadmin.R
import com.example.realtimecrudadmin.databinding.ActivityMenuCrearReporteBinding

class MenuCrearReportes : AppCompatActivity() {

    private lateinit var binding:ActivityMenuCrearReporteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuCrearReporteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPerdido.setOnClickListener{
            val intent = Intent(this@MenuCrearReportes,UploadOP::class.java)
            startActivity(intent)
        }

        binding.btnEncontrado.setOnClickListener{
            val intent = Intent(this@MenuCrearReportes,UploadOE::class.java)
            startActivity(intent)
        }

        binding.cRepIconBack.setOnClickListener{
            val intent = Intent(this@MenuCrearReportes,HomeUser::class.java)
            startActivity(intent)
        }
    }
}