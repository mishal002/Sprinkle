package com.example.sprinkle.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sprinkle.R
import com.example.sprinkle.databinding.ActivityShowDataBinding

class ShowDataActivity : AppCompatActivity() {

    lateinit var binding: ActivityShowDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)
        binding= ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}