package com.example.sprinkle.all_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.sprinkle.Activity.shooping_home
import com.example.sprinkle.databinding.FragmentHomeFragmentBinding
import com.example.sprinkle.Activity.HomeChoclateCake as HomeChoclateCake1


@Suppress("UNREACHABLE_CODE")
class home_fragment : Fragment() {
    lateinit var binding: FragmentHomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeFragmentBinding.inflate(layoutInflater)

//        Image Slider
        imageSlider()
//        Button click
        binding.shoopingHome.setOnClickListener {
            val intent = Intent(context, shooping_home::class.java)
            startActivity(intent) }


        binding.homeChocolate1.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }


        binding.homeChocolate2.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }


        binding.homeChocolate3.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }

        binding.homeChocolate21.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }

        binding.homeChocolate22.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }

        binding.homeChocolate23.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }

        binding.homeChocolate31.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }

        binding.homeChocolate32.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }

        binding.homeChocolate3Thrd.setOnClickListener {
            val intent = Intent(context, HomeChoclateCake1::class.java)
            startActivity(intent)
        }






        binding.menuHome.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        return binding.root
//        Spinner

    }

    fun imageSlider() {
        val imageList = ArrayList<SlideModel>()

        imageList.add(
            SlideModel(
                "https://foodypoint.in/wp-content/uploads/2018/01/cake-banner-1.jpg",
            )
        )
        imageList.add(
            SlideModel(
                "https://www.midlandbakers.com/wp-content/uploads/2020/07/cake-banner.jpg",
            )
        )
        imageList.add(
            SlideModel(
                "https://cdn.shopify.com/s/files/1/0018/9340/0623/collections/All-you-need-are-a-couple-of-clicks.jpg?v=1616836361",
            )
        )
        imageList.add(
            SlideModel(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZ5J-vpFnINmtOOCRNVAegcTfNw-Br66ZJN0C6xUQ9Lc5oK3Pi_Q073XPfQQ3xD8Q45g&usqp=CAU",
            )
        )
        imageList.add(
            SlideModel(
                "https://www.tfcakes.in/catalog/view/theme/default/image/banner2s.jpg",
            )
        )
        imageList.add(
            SlideModel(
                "https://www.cakesandbakes.co.uk/files/1800X600/main-banner-24092020-1.jpg",
            )
        )
        binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }
}

