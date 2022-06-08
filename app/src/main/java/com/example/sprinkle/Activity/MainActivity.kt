package com.example.sprinkle.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.sprinkle.R
import com.example.sprinkle.all_fragment.account_fragment
import com.example.sprinkle.all_fragment.home_fragment
import com.example.sprinkle.all_fragment.offer_fragment
import com.example.sprinkle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        addFragmentToFragment(home_fragment())

        binding.homeBtn.setOnClickListener {
            addFragmentToFragment(home_fragment())
        }

        binding.offer.setOnClickListener {
            addFragmentToFragment(offer_fragment())
        }

        binding.myAccount.setOnClickListener {
            addFragmentToFragment(account_fragment())
        }

        binding.readOder.setOnClickListener {
            val intent = Intent(this,ShowDataActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun addFragmentToFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.commit()
    }
}

