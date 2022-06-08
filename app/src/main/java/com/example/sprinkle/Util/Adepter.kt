package com.example.sprinkle.Util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprinkle.Activity.GetDataActivity
import com.example.sprinkle.R

class Adepter(private val getDataActivity: GetDataActivity, private val l1: ArrayList<ModelData>) : RecyclerView.Adapter<Adepter.ViewData>() {

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        val id_txt= itemView.findViewById<TextView>(R.id.id_txt)
        val name_txt = itemView.findViewById<TextView>(R.id.name_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        val view = LayoutInflater.from(this.getDataActivity).inflate(R.layout.itemfile,parent,false)
        return ViewData(view)

    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.id_txt.text=l1[position].id
        holder.name_txt.text=l1[position].name
    }

    override fun getItemCount(): Int {
        return l1.size
    }
}