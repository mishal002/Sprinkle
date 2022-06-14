package com.example.sprinkle.all_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.sprinkle.databinding.FragmentHomeFragmentBinding
import com.example.sprinkle.databinding.FragmentOfferFragmentBinding
import com.example.sprinkle.Activity.HomeChoclateCake as HomeChoclateCake1


@Suppress("UNREACHABLE_CODE")
class offer_fragment : Fragment() {
    lateinit var binding: FragmentOfferFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOfferFragmentBinding.inflate(layoutInflater)


        binding.menuHome.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        return binding.root
    }
}
