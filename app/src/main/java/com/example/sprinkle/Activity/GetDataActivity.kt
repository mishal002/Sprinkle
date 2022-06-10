package com.example.sprinkle.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.sprinkle.R
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
            db.insertData(
                binding.nameEdt.text.toString(),
                binding.mobileEdt.text.toString(),
                binding.pincodeEdt.text.toString(),
                binding.kgEdt.text.toString(),
                binding.other1Edt.text.toString()
            )
            list = db.readData()
            onBackPressed()
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        }


        binding.backArrow.setOnClickListener {
            onBackPressed()
        }
        binding.kg05.setOnClickListener {
            Toast.makeText(this, "KG 0.5", Toast.LENGTH_SHORT).show()
        }
        binding.kg1.setOnClickListener {
            Toast.makeText(this, "KG 1", Toast.LENGTH_SHORT).show()
        }
        binding.kg2.setOnClickListener {
            Toast.makeText(this, "KG 2", Toast.LENGTH_SHORT).show()
        }
    }
}