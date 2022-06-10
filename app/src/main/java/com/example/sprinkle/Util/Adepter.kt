package com.example.sprinkle.Util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprinkle.Activity.ShowDataActivity
import com.example.sprinkle.R

class Adepter(private val getDataActivity: ShowDataActivity, private val l1: ArrayList<ModelData>) :
    RecyclerView.Adapter<Adepter.ViewData>() {

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val id_txt: TextView = itemView.findViewById<TextView>(R.id.id_txt)
        val id_1_txt: TextView = itemView.findViewById<TextView>(R.id.id_1_txt)
        val name_txt: TextView = itemView.findViewById<TextView>(R.id.name_txt)
        val mobile_txt: TextView = itemView.findViewById<TextView>(R.id.mobile_txt)
        val pincode_txt: TextView = itemView.findViewById<TextView>(R.id.pincode_txt)
        val kg_txt: TextView = itemView.findViewById<TextView>(R.id.kg_txt)
        val other_1_txt: TextView = itemView.findViewById<TextView>(R.id.other_1_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        val view =
            LayoutInflater.from(this.getDataActivity).inflate(R.layout.itemfile, parent, false)
        return ViewData(view)

    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        holder.id_txt.text = l1[position].id
        holder.id_1_txt.text = l1[position].id
        holder.name_txt.text = l1[position].name
        holder.mobile_txt.text = l1[position].mobile
        holder.pincode_txt.text = l1[position].pincode
        holder.kg_txt.text = l1[position].kg
        holder.other_1_txt.text = l1[position].other1
    }

    override fun getItemCount(): Int {
        return l1.size
    }
}