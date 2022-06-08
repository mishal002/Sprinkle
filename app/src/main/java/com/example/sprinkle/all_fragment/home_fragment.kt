package com.example.sprinkle.all_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.sprinkle.databinding.FragmentHomeFragmentBinding
import com.example.sprinkle.Activity.HomeChoclateCake
import com.example.sprinkle.Activity.shooping_home


class home_fragment : Fragment() {

    lateinit var binding: FragmentHomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeFragmentBinding.inflate(layoutInflater)

//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_fragment, container, false)


        binding.shoopingHome.setOnClickListener {
            val intent = Intent(context, shooping_home::class.java)
            startActivity(intent)
        }
        binding.homeChocolate1.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}

