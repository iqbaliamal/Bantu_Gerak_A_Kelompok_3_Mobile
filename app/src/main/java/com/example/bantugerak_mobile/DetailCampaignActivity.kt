package com.example.bantugerak_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import com.example.bantugerak_mobile.helper.helper
import com.example.bantugerak_mobile.model.Campaign
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_campaign.*
import kotlinx.android.synthetic.main.activity_donasi.*
import kotlinx.android.synthetic.main.toolbar.*


class DetailCampaignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_campaign)

//        supportActionBar?.hide()

        val donasiActivity = DonasiActivity()

        btn_donasi.setOnClickListener {
            donasiActivity.show(supportFragmentManager, "Bottom Sheet Dialog")
        }


        getData()


    }


    private fun getData() {
        val data = intent.getStringExtra("extra")
        val campaign = Gson().fromJson<Campaign>(data, Campaign::class.java)

        val totalSementara = Integer.valueOf(campaign.sum_donation[0].total)
        val target = Integer.valueOf(campaign.target_donation)
        //set value

        title_detail.text = campaign.title
        danaTerkumpulDetail.text = helper().moneyFormat(totalSementara)
        targetDetail.text = helper().moneyFormat(target)
        maxDateDetail.text = campaign.max_date
        namaPenggalangDetail.text = campaign.user.name
        cerita.text = campaign.description

        val img = campaign.image
        Picasso.get()
                .load(img)
                .resize(400, 300)
                .into(image_detail)

        helper().setToolbar(this, toolbar  , campaign.title)

    }

    fun bottomSheet(){


    }

//    fun showBottomSheet(){
//        btnShowBottomSheet = findViewById(R.id.btn_donasi);
//
//        // adding on click listener for our button.
//        btnShowBottomSheet.setOnClickListener {
//
//            // on below line we are creating a new bottom sheet dialog.
//            val dialog = BottomSheetDialog(this)
//
//            // on below line we are inflating a layout file which we have created.
//            val view = layoutInflater.inflate(R.layout.activity_donasi, null)
//
//            // on below line we are creating a variable for our button
//            // which we are using to dismiss our dialog.
////            val btnClose = view.findViewById<Button>(R.id.idBtnDismiss)
//
//            // on below line we are adding on click listener
//            // for our dismissing the dialog button.
////            btnClose.setOnClickListener {
////                // on below line we are calling a dismiss
////                // method to close our dialog.
////                dialog.dismiss()
////            }
//            // below line is use to set cancelable to avoid
//            // closing of dialog box when clicking on the screen.
//            dialog.setCancelable(false)
//
//            // on below line we are setting
//            // content view to our view.
//            dialog.setContentView(view)
//
//            // on below line we are calling
//            // a show method to display a dialog.
//            dialog.show()
//        }
//    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}