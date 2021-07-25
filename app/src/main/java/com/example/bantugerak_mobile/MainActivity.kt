package com.example.bantugerak_mobile

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import android.content.ContentValues.TAG
import android.content.Intent
import com.example.bantugerak_mobile.fragment.HomeFragment
import com.example.bantugerak_mobile.fragment.campaignFragment
import com.example.bantugerak_mobile.fragment.donationFragment
import com.example.bantugerak_mobile.fragment.profileFragment
import com.example.bantugerak_mobile.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*
import androidx.collection.arraySetOf as arraySetOf1

class MainActivity : AppCompatActivity() {
//    lateinit var myDb: MyDatabase

    private val fragmentHome: Fragment = HomeFragment()
    private val fragmentDonation: Fragment = donationFragment()
    private val fragmentCampaign: Fragment = campaignFragment()
    private val fragmentProfile: Fragment = profileFragment()

    private var statusLogin  = false
    private lateinit var s:SharedPref




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        s = SharedPref(this)



//        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()

        makeCurrentFragment(fragmentHome)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.homeFragment -> {
                    makeCurrentFragment(fragmentHome)
                    Log.i(TAG, "Home Selected")
                    badgeClear(R.id.homeFragment)
                }

                R.id.donationFragment -> {
//                    makeCurrentFragment(fragmentDonation)
//                    Log.i(TAG, "Donation Selected")
//                    badgeClear(R.id.donationFragment)
                    if (s.getStatusLogin()) {
                        makeCurrentFragment(fragmentDonation)
                        Log.i(TAG, "Donation Selected")
                        badgeClear(R.id.donationFragment)
                    } else {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }

                R.id.campaignFragment -> {
                    makeCurrentFragment(fragmentCampaign)
                    Log.i(TAG, "Campaign Selected")
                    badgeClear(R.id.campaignFragment)
                }

                R.id.profileFragment -> {
                    if (s.getStatusLogin()) {
                        makeCurrentFragment(fragmentProfile)
                        Log.i(TAG, "Settings Selected")
                        badgeClear(R.id.donationFragment)
                    } else {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }

            }
            true
        }
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        val navController = findNavController(R.id.fragment)
//
//        val appBarConfiguration = AppBarConfiguration(androidx.collection.arraySetOf(R.id.homeFragment, R.id.donationFragment, R.id.campaignFragment, R.id.profileFragment))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        bottomNavigationView.setupWithNavController(navController)

    }

    private fun badgeSetup(id: Int, alerts: Int) {
        val bottom_navigation2 = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val badge = bottom_navigation2.getOrCreateBadge(id)
        badge.isVisible = true
        badge.number = alerts

    }


    private fun badgeClear(id: Int) {
        val bottom_navigation3 = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val badgeDrawable = bottom_navigation3.getBadge(id)
        if (badgeDrawable != null) {
            badgeDrawable.isVisible = false
            badgeDrawable.clearNumber()
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, fragment)
                commit()
            }


}