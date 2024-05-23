package com.example.rv_1203

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rv_1203.databinding.ActivityRegistrarUsuarioBinding
import com.google.firebase.auth.FirebaseAuth

/*
* activity para registro o sign in
* */



class Registrar_usuario : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarUsuarioBinding
    private lateinit var firebaseauth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseauth = FirebaseAuth.getInstance()
        binding.volverLogin.setOnClickListener{
            val intent = Intent(this,Login::class.java)
            startActivity((intent))
        }

        binding.btnConfirmRegister.setOnClickListener {
            val user_mail = binding.edittextEmailSignin.text.toString()
            val user_pass = binding.edittextClaveSignin.text.toString()
            val user_confirm = binding.edittextComfirmarClaveSignin.text.toString()

            if (user_mail.isNotEmpty() && user_pass.isNotEmpty() && user_confirm.isNotEmpty()){
                if (user_pass==user_confirm){
                    firebaseauth.createUserWithEmailAndPassword(user_mail,user_pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this,Login::class.java)
                            startActivity((intent))
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Las claves no coinciden.", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Rellene todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}