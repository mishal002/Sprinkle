package com.example.sprinkle.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprinkle.R
import com.example.sprinkle.Util.Adepter
import com.example.sprinkle.Util.DBHelpar
import com.example.sprinkle.Util.ModelData
import com.example.sprinkle.databinding.ActivityGetDataBinding


class GetDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityGetDataBinding
    var list = arrayListOf<ModelData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data)
        binding = ActivityGetDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelpar(this)

        binding.buyCakeBtn.setOnClickListener {
            db.insertData(binding.nameEdt.toString())
            list = db.readData()
            setUpRV(list)
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

        }

        binding.readDataBtn.setOnClickListener {
            list = db.readData()
            setUpRV(list)
        }
    }

    fun setUpRV(l1: ArrayList<ModelData>) {

        val adepter = Adepter(this, l1)
        val lm = LinearLayoutManager(this)
        binding.rvView.layoutManager = lm
        binding.rvView.adapter = adepter
    }
}