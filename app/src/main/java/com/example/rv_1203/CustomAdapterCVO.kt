package com.example.rv_1203

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
 Adaptador para CardView de Objeto
*/

class CustomAdapterCVO: RecyclerView.Adapter<CustomAdapterCVO.ViewHolder>() {
    val imagenCVP = intArrayOf(R.drawable.ic_launcher_background,R.drawable.add_create_new_plus_icon)
    val nombreCVP = arrayOf("Mamacita","Mamasota")
    val fechaCVP = arrayOf("20/04/2024","18/04/2024")
    val ubicacionCVP = arrayOf("Velarias","B16")


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CustomAdapterCVO.ViewHolder {
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





