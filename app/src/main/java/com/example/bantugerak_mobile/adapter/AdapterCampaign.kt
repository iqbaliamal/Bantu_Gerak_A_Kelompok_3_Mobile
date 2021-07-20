package com.example.bantugerak_mobile.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.R
import com.example.bantugerak_mobile.DetailCampaignActivity
import com.example.bantugerak_mobile.model.Campaign
import com.google.gson.Gson
import java.util.*

class AdapterCampaign(var activity: Activity, var data:ArrayList<Campaign>): RecyclerView.Adapter<AdapterCampaign.Holder>() {
    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvTitle = view.findViewById<TextView>(com.example.bantugerak_mobile.R.id.titleTv)
        val tvPenggalang = view.findViewById<TextView>(com.example.bantugerak_mobile.R.id.penggalangTv)
        val tvDanaterkumpul = view.findViewById<TextView>(com.example.bantugerak_mobile.R.id.danaTv)
        val tvDanatarget = view.findViewById<TextView>(com.example.bantugerak_mobile.R.id.targetDonationTv)
        val tvMaxdate = view.findViewById<TextView>(com.example.bantugerak_mobile.R.id.endDateTv)
        val ivImage = view.findViewById<ImageView>(com.example.bantugerak_mobile.R.id.imageIv)

        val layout = view.findViewById<CardView>(com.example.bantugerak_mobile.R.id.row_campaign)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(com.example.bantugerak_mobile.R.layout.row_campaign, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvTitle.text = data[position].title
        holder.tvPenggalang.text = data[position].penggalang
        holder.tvDanaterkumpul.text = data[position].danaSementara
        holder.tvDanatarget.text = data[position].target
        holder.tvMaxdate.text = data[position].maxDate
        holder.ivImage.setImageResource(data[position].gambar)

        holder.layout.setOnClickListener{
            val goToActiviti = Intent(activity, DetailCampaignActivity::class.java)

            val str = Gson().toJson(data[position], Campaign::class.java)

            goToActiviti.putExtra( "extra", str)

            activity.startActivity(goToActiviti)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}