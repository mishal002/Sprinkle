package com.example.sprinkle.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprinkle.R
import com.example.sprinkle.Util.Adepter
import com.example.sprinkle.Util.DBHelpar
import com.example.sprinkle.Util.ModelData
import com.example.sprinkle.databinding.ActivityShowDataBinding
import android.widget.Toast.makeText as makeText1

class ShowDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityShowDataBinding
    var list = arrayListOf<ModelData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)
        binding = ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelpar(this)
        list = db.readData()
        setUpRV(list)


        binding.addDataBtn.setOnClickListener {
            val intent = Intent(this, GetDataActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Add Data", Toast.LENGTH_SHORT).show()
        }

    }

    fun setUpRV(l1: ArrayList<ModelData>) {

        val adepter = Adepter(this, l1)
        val lm = LinearLayoutManager(this)
        binding.rvView.layoutManager = lm
        binding.rvView.adapter = adepter
    }
}