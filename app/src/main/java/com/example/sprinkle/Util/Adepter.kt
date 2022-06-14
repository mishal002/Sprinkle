package com.example.sprinkle.Util

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sprinkle.Activity.ShowDataActivity
import com.example.sprinkle.R


class Adepter(val getDataActivity: ShowDataActivity, val l1: ArrayList<ModelData>) :
    RecyclerView.Adapter<Adepter.ViewData>() {


    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val id_txt: TextView = itemView.findViewById<TextView>(R.id.id_txt)
        val id_1_txt: TextView = itemView.findViewById<TextView>(R.id.id_1_txt)
        val name_txt: TextView = itemView.findViewById<TextView>(R.id.name_txt)
        val mobile_txt: TextView = itemView.findViewById<TextView>(R.id.mobile_txt)
        val pincode_txt: TextView = itemView.findViewById<TextView>(R.id.pincode_txt)
        val kg_txt: TextView = itemView.findViewById<TextView>(R.id.kg_txt)
        val other_1_txt: TextView = itemView.findViewById<TextView>(R.id.other_1_txt)
        val address_txt: TextView = itemView.findViewById<TextView>(R.id.address_txt)
        val time_txt: TextView = itemView.findViewById<TextView>(R.id.time_txt)
        val delete_btn: ImageView = itemView.findViewById<ImageView>(R.id.delete_btn)
        val update_btn: ImageView = itemView.findViewById<ImageView>(R.id.update_btn)
        val save_btn: Button = itemView.findViewById<Button>(R.id.save_btn)
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
        holder.address_txt.text = l1[position].address
        holder.time_txt.text = l1[position].time

        holder.delete_btn.setOnClickListener {
            DBHelpar(getDataActivity).deleteData(l1[position].id)
            var l1 = DBHelpar(getDataActivity).readData()
            with(getDataActivity) {
                setUpRV(l1)
            }
        }

        holder.update_btn.setOnClickListener {
            updateDailog(position)
        }

    }

    override fun getItemCount(): Int {
        return l1.size
    }

    fun updateDailog(position: Int) {
        var dialog = Dialog(getDataActivity)
        dialog.setContentView(R.layout.dialog_item)
        dialog.show()


        var name_edt_update = dialog.findViewById<EditText>(R.id.name_edt_update)
        var mobile_edt_update = dialog.findViewById<EditText>(R.id.mobile_edt_update)
        var kg_edt_update = dialog.findViewById<EditText>(R.id.kg_edt_update)
        var other1_edt_update = dialog.findViewById<EditText>(R.id.other1_edt_update)
        var pincode_edt_update = dialog.findViewById<EditText>(R.id.pincode_edt_update)
        var address_edt_update = dialog.findViewById<EditText>(R.id.address_edt_update)
        var time_edt_update = dialog.findViewById<EditText>(R.id.time_edt_update)
        var submit_data_btn = dialog.findViewById<Button>(R.id.submit_data_btn)


        submit_data_btn.setOnClickListener {
            DBHelpar(getDataActivity).updateData(
                l1[position].id, name_edt_update.text.toString(),
                mobile_edt_update.text.toString(),
                kg_edt_update.text.toString(),
                other1_edt_update.text.toString(),
                pincode_edt_update.text.toString(),
                address_edt_update.text.toString(),
                time_edt_update.text.toString(),
            )

            val db = DBHelpar(getDataActivity)
            var list = db.readData()
            getDataActivity.setUpRV(list)

            dialog.dismiss()
        }

    }
}




