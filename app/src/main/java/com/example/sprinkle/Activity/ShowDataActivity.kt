package com.example.sprinkle.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprinkle.R
import com.example.sprinkle.Util.Adepter
import com.example.sprinkle.Util.DBHelpar
import com.example.sprinkle.Util.ModelData
import com.example.sprinkle.databinding.ActivityShowDataBinding

class ShowDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityShowDataBinding
    var list = arrayListOf<ModelData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)
        binding= ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DBHelpar(this)

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