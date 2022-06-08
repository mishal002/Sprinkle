package com.example.sprinkle.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sprinkle.R
import com.example.sprinkle.databinding.ActivityShoopingHomeBinding

class shooping_home : AppCompatActivity() {
    lateinit var binding: ActivityShoopingHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shooping_home)

    }

}