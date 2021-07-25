package com.example.bantugerak_mobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bantugerak_mobile.R.*
import com.example.bantugerak_mobile.helper.helper
import com.example.bantugerak_mobile.model.Campaign
import com.example.bantugerak_mobile.model.SumDonation
import com.example.bantugerak_mobile.util.listener.CampaignItemListener
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class AdapterCampaign(var data: ArrayList<Campaign>):RecyclerView.Adapter<AdapterCampaign.Holder>() {


    var listSum: List<SumDonation> = ArrayList()
    private lateinit var campaignItemListener: CampaignItemListener

    fun itemListener(listener: CampaignItemListener) {
        this.campaignItemListener = listener
    }

    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvTitle: TextView = view.findViewById(id.titleTv)
        val tvPenggalang: TextView = view.findViewById(id.penggalangTv)
//        val tvDanaterkumpul: TextView = view.findViewById(id.danaTv)
        val tvDanatarget: TextView = view.findViewById(id.targetDonationTv)
        val tvMaxdate: TextView = view.findViewById(id.endDateTv)
        val ivImage: ImageView = view.findViewById(id.imageIv)

        val layout = view.findViewById<CardView>(id.r_campaign)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(layout.row_campaign, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val target = Integer.valueOf(data[position].target_donation)
        holder.tvTitle.text = data[position].title
        holder.tvPenggalang.text = data[position].user.name
        holder.tvDanatarget.text = helper().moneyFormat(target)
        holder.tvMaxdate.text = data[position].max_date
        val image = data[position].image
        Picasso.get()
                .load(image)
                .placeholder(drawable.circle_logo)
                .error(drawable.circle_logo)
                .into(holder.ivImage)

        holder.itemView.setOnClickListener{
            /*val goToActiviti = Intent(activity, DetailCampaignActivity::class.java)

            val str = Gson().toJson(data[position], Campaign::class.java)

            goToActiviti.putExtra( "extra", str)

            activity.startActivity(goToActiviti)*/

            campaignItemListener.onClicked(data[position])

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

