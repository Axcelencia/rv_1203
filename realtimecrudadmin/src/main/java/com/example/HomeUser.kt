package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realtimecrudadmin.R
import com.example.realtimecrudadmin.databinding.ActivityHomeUserBinding

private lateinit var binding: ActivityHomeUserBinding
class HomeUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeIconAdd.setOnClickListener{
            val intent = Intent(this,MenuCrearReportes::class.java)
            startActivity(intent)
        }

        binding.homeIconRegs.setOnClickListener{
            val intent = Intent(this,ArchivoReportes::class.java)
            startActivity(intent)
        }

        binding.homeLogoutIcon.setOnClickListener{
            finish()
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
    }
}