package com.example.bantugerak_mobile.model

import java.io.Serializable

class Campaigns: Serializable {
    //    @PrimaryKey(autoGenerate = true)
    //    @ColumnInfo(name = "idTb")
    //    public int idTb;
    var id = 0
    lateinit var title: String
    lateinit var slug: String
    var category_id = 0
    var target_donation = 0
    lateinit var max_date: String
    lateinit var description: String
    lateinit var image: String
    var user_id = User()
    lateinit var created_at: String
    lateinit var updated_at: String
    var sum_donation = SumDonation()

    var campaigns:ArrayList<Campaign> = ArrayList()

    var selected = true
}