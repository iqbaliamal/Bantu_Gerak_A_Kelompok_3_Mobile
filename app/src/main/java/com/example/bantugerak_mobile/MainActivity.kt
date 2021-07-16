package com.example.bantugerak_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*
import androidx.collection.arraySetOf as arraySetOf1

class MainActivity : AppCompatActivity() {
//    lateinit var myDb: MyDatabase




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


//        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.fragment)

        val appBarConfiguration = AppBarConfiguration(androidx.collection.arraySetOf(R.id.homeFragment, R.id.donationFragment, R.id.campaignFragment, R.id.profileFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)

//        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
//        val imageList = ArrayList<SlideModel>()
//
//        imageList.add(SlideModel("https://cdn1-production-images-kly.akamaized.net/Lp4ZMNdzQ89iphOeDwpz1A0UV5g=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2703835/original/060532300_1547463460-macam-macam_bencana_alam.jpg"))
//        imageList.add(SlideModel("https://www.its.ac.id/news/wp-content/uploads/sites/2/2018/12/letusan-gunung-krakatau_20170923_174854.jpg"))
//        imageList.add(SlideModel("https://apahabar.com/wp-content/uploads/2020/06/1e57a22c-c7a3-43fb-b7c4-ad3e5bdd11f8.jpg"))
//        imageList.add(SlideModel("https://awsimages.detik.net.id/visual/2020/01/02/05686423-6018-4448-b20e-9cc415885723.png?w=650"))
//
//        imageSlider.setImageList(imageList,ScaleTypes.FIT)
    }


}