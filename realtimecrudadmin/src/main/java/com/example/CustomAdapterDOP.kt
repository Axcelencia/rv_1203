package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.realtimecrudadmin.R


/* Custom Adapter - Detalle Objeto Perdido */
class CustomAdapterDOP: RecyclerView.Adapter<CustomAdapterDOP.ViewHolder>() {

    val imagenD = intArrayOf(R.drawable.audifonos_jbl)
    val nombreD = arrayOf("Audifones JBL SS2")
    val fechaD = arrayOf("12/04/2024")
    val ubicacionD = arrayOf("Velarias")
    val detallesD = arrayOf("Aproximadamente por las bancas de madera")
    val usernameD = arrayOf("Natanahuel Cano Moreno")

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CustomAdapterDOP.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.detail_layout, viewGroup, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImg.setImageResource(imagenD[i])
        viewHolder.itemNombre.text = nombreD[i]
        viewHolder.itemUbi.text = ubicacionD[i]
        viewHolder.itemFecha.text = fechaD[i]
        viewHolder.itemDetalles.text = detallesD[i]
        viewHolder.itemUser_name.text = usernameD[i]
    }

    override fun getItemCount(): Int {
        return nombreD.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImg: ImageView
        var itemNombre: TextView
        var itemUbi: TextView
        var itemFecha: TextView
        var itemDetalles: TextView
        var itemUser_name: TextView

        init{
            itemImg = itemView.findViewById(R.id.detail_image)
            itemNombre = itemView.findViewById(R.id.detail_nombre)
            itemFecha = itemView.findViewById(R.id.detail_fecha)
            itemUbi = itemView.findViewById(R.id.detail_lugar)
            itemDetalles = itemView.findViewById(R.id.detail_details)
            itemUser_name = itemView.findViewById(R.id.detail_username)
        }
    }

}