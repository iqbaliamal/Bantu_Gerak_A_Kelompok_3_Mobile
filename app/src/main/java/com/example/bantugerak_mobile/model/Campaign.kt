package com.example.bantugerak_mobile.model

import java.io.Serializable

class Campaign : Serializable {

    lateinit var title:String
    lateinit var penggalang:String
    lateinit var danaSementara:String
    lateinit var terkumpultxt:String
    lateinit var target:String
    lateinit var maxDate:String
    lateinit var hariLagi:String
    var gambar:Int = 0

}