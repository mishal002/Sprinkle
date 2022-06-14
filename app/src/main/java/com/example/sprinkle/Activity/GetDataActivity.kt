package com.example.sprinkle.Activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sprinkle.R
import com.example.sprinkle.Util.DBHelpar
import com.example.sprinkle.Util.ModelData
import com.example.sprinkle.databinding.ActivityGetDataBinding
import java.util.*


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
            if (binding.pincodeEdt.text.isNullOrEmpty()) {
                binding.pincodeEdt.error = "Pls Enter Pincode"
            } else if (binding.nameEdt.text.isNullOrEmpty()) {
                binding.nameEdt.error = "Pls Enter Name"
            } else if (binding.mobileEdt.text.isNullOrEmpty()) {
                binding.mobileEdt.error = "Pls Enter Mobile"
            } else if (binding.kgEdt.text.isNullOrEmpty()) {
                binding.kgEdt.error = "Pls Enter Kg"
            } else if (binding.addressEdt.text.isNullOrEmpty()) {
                binding.addressEdt.error = "Pls Enter Address"
            } else if (binding.timeEdt.text.isNullOrEmpty()) {
                binding.timeEdt.error = "Pls Enter Time"
            } else {
                db.insertData(
                    binding.nameEdt.text.toString(),
                    binding.mobileEdt.text.toString(),
                    binding.pincodeEdt.text.toString(),
                    binding.kgEdt.text.toString(),
                    binding.other1Edt.text.toString(),
                    binding.addressEdt.text.toString(),
                    binding.timeEdt.text.toString()
                )
                list = db.readData()
                onBackPressed()
//                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }

        }
//        Date



//        binding.dateEdt.setOnClickListener {
//            val datePickerDialog = DatePickerDialog(this, R.style.MyDatePickerStyle , DatePickerDialog.OnDateSetListener
//            { view, year, monthOfYear, dayOfMonth ->
//                ad_f2_binding.bdateEdt.setText("" + dayOfMonth + " - " + (monthOfYear+1) + " - " + year)
//            }, year, month, day)
//            datePickerDialog.show()
//        }





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