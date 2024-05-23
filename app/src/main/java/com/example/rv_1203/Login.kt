package com.example.rv_1203

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rv_1203.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

private lateinit var binding: ActivityLoginBinding
private lateinit var firebaseAuth: FirebaseAuth
class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.txtIrARegistro.setOnClickListener{
            val intent = Intent(this,Registrar_usuario::class.java)
            startActivity((intent))
        }

        binding.btnLogin.setOnClickListener{
            val user_mail = binding.edittextEmailLogin.text.toString()
            val user_pass = binding.edittextClaveLogin.text.toString()

            if (user_mail.isNotEmpty() && user_pass.isNotEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(user_mail,user_pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this,Home_user::class.java)
                            startActivity((intent))
                        }else{
                            Toast.makeText(this, "Alguno de los datos es erroneo.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this, "Rellene todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }