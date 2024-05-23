package com.example

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.realtimecrudadmin.R
import com.example.realtimecrudadmin.databinding.ActivityUploadOpBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.Calendar
import java.util.UUID


class UploadOP : AppCompatActivity() {
    lateinit var databaseReference : DatabaseReference

    private val selectedCalendar = Calendar.getInstance()
    private lateinit var image_obj_rep_p : ImageView
    lateinit var binding : ActivityUploadOpBinding
    var fileUri : Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //var auth = FirebaseAuth.getInstance()
        //val uid = auth.currentUser?.uid
        binding = ActivityUploadOpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseReference = FirebaseDatabase.getInstance().getReference("Reportes_P")

        //botón para seleccionar imagen
        var btn_upload_img : Button = findViewById(R.id.add_img_arop)
        var btn_upload_rep : Button = findViewById(R.id.btn_confirm_register_obj_per)

        binding.btnCancelUop.setOnClickListener{
            intent = Intent(this,MenuCrearReportes::class.java)
            startActivity(intent)
        }

        btn_upload_img.setOnClickListener{
            image_obj_rep_p = findViewById(R.id.img_rep_p)
            uploadImage(image_obj_rep_p)
        }

        btn_upload_rep.setOnClickListener{

            val op_nombre = binding.edittextNombreObjPer.text.toString()
            val op_ubi = binding.edittextLugarObjPer.text.toString()
            val op_detalles = binding.edittextDetallesObjPer.text.toString()
            val op_fecha = binding.textViewFechaSUpdOp.text.toString()


            if (fileUri != null){
                uploadImg()
            }else{
                Toast.makeText(applicationContext,"Agrega una imagen, puta",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun uploadImage(image : ImageView){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(intent,"Selecciona una imagen:"),0
        )
    }
    fun onClickFechaROP(v: View?){
        val selectedDate = findViewById<TextView>(R.id.textView_fecha_s_upd_op)
        val year = selectedCalendar.get(Calendar.YEAR)
        val month = selectedCalendar.get(Calendar.MONTH)
        val day = selectedCalendar.get(Calendar.DAY_OF_MONTH)
        val listener = DatePickerDialog.OnDateSetListener{_: DatePicker?, y: Int, m: Int, d: Int ->
            selectedCalendar.set(y,m,d)
            selectedDate.text = "$y-$m-$d"
        }
        DatePickerDialog(this,listener,year,month,day).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == RESULT_OK && data != null && data.data != null){
            fileUri = data.data
            try {
                val bitmap : Bitmap = MediaStore.Images.Media.getBitmap(contentResolver,fileUri)
                image_obj_rep_p.setImageBitmap(bitmap)
            }catch (e: Exception){
                Log.e("Exception","Error: "+e)
            }
        }
    }

    fun uploadImg(){
        if (fileUri != null){
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Creando reporte...")
            progressDialog.setMessage("Almacenando datos...")
            progressDialog.show()

            val ref : StorageReference = FirebaseStorage.getInstance().getReference()
                .child(UUID.randomUUID().toString())
            ref.putFile(fileUri!!).addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(applicationContext,"Reporte creado correctamente",Toast.LENGTH_LONG).show()
                val intent = Intent(this@UploadOP,MenuCrearReportes::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(applicationContext,"Ocurrió un error...",Toast.LENGTH_LONG).show()
            }

        }
    }

}