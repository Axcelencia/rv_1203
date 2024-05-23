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

class CustomAdapterCVOP: RecyclerView.Adapter<CustomAdapterCVOP.ViewHolder>() {
    val imagenCVP = intArrayOf(R.drawable.audifonos_jbl,R.drawable.llaves,R.drawable.xiaom_cargador,R.drawable.mouse_logitech)
    val nombreCVP = arrayOf("Audifonos JBL","Llaves","Cargador Xiaomi","Mouse Logitech")
    val fechaCVP = arrayOf("20-04-2024","18-04-2024","20-03-2024","20-05/2024")
    val ubicacionCVP = arrayOf("Velarias","B16","CITA 3","CITA 3")


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CustomAdapterCVOP.ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

//CVP = CardViewPerdido

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImageCVP.setImageResource(imagenCVP[i])
        viewHolder.itemNombreCVP.text = nombreCVP[i]
        viewHolder.itemUbiCVP.text = ubicacionCVP[i]
        viewHolder.itemFechaCVP.text = fechaCVP[i]
    }

    override fun getItemCount(): Int {
        return nombreCVP.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImageCVP: ImageView
        var itemNombreCVP: TextView
        var itemUbiCVP: TextView
        var itemFechaCVP: TextView

        init{
            itemImageCVP = itemView.findViewById(R.id.item_image)
            itemNombreCVP = itemView.findViewById(R.id.item_title)
            itemFechaCVP = itemView.findViewById(R.id.item_cvp_fecha)
            itemUbiCVP = itemView.findViewById(R.id.item_cvp_lugar)
        }
    }

}