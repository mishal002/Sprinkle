package com.example.sprinkle.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.example.sprinkle.R
import com.example.sprinkle.databinding.ActivityHomeChocolateCakeBinding

class HomeChoclateCake: AppCompatActivity() {

    lateinit var binding : ActivityHomeChocolateCakeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_chocolate_cake)
        binding=ActivityHomeChocolateCakeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.homeChocolate1.setOnClickListener {
            val intent = Intent(this, GetDataActivity::class.java)
            startActivity(intent)
        }

        binding.homeChocolate2.setOnClickListener {
            val intent = Intent(this, GetDataActivity::class.java)
            startActivity(intent)
        }

        binding.menuHome.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.shoopingHome.setOnClickListener {
            val intent = Intent(this, ShowDataActivity::class.java)
            startActivity(intent)
        }

    }


}