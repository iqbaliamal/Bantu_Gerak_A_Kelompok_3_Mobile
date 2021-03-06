package com.example.bantugerak_mobile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_donasi.*

class DonasiActivity : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.activity_donasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        donasi_sekarang.setOnClickListener {
//            Toast.makeText(context, "You pressed this button", Toast.LENGTH_SHORT).show()
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://bantugerak.workshopjti.com/")
            startActivity(openURL)
//            Toast.makeText(context, "Donasi Anda Sedang Diproses", Toast.LENGTH_SHORT).show()
//            val intent = Intent(context, MainActivity::class.java)
//            startActivity(intent)
        }
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_donasi)
//
//        donasi_sekarang.setOnClickListener {
//            Toast.makeText(this, "You pressed this button", Toast.LENGTH_SHORT).show()
//        }
//    }
}