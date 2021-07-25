package com.example.bantugerak_mobile.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bantugerak_mobile.DetailCampaignActivity
import com.example.bantugerak_mobile.R
import com.example.bantugerak_mobile.adapter.AdapterCampaign
import com.example.bantugerak_mobile.app.ApiConfig
import com.example.bantugerak_mobile.model.Campaign
import com.example.bantugerak_mobile.model.ResponModel
import com.example.bantugerak_mobile.util.listener.CampaignItemListener
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [campaignFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class campaignFragment : Fragment(), CampaignItemListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var campaignRv: RecyclerView

    private lateinit var campaignAdapter: AdapterCampaign

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_campaign, container, false)

        init(view)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL


        getCampaign()

        return view
    }

    private var listCampaign: ArrayList<Campaign> = ArrayList()
    fun getCampaign(){
        ApiConfig.instanceRetrofit.getCampaign().enqueue(object : Callback<ResponModel> {
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                if(res.success == 1){
                    listCampaign = res.campaigns
                    displayCampaign()
                }
            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {

            }

        })
    }

    fun displayCampaign(){
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
//        campaignRv.adapter = AdapterCampaign(requireActivity(),listCampaign)
//        campaignRv.adapter = AdapterCampaign(listCampaign)
        campaignAdapter = AdapterCampaign(listCampaign)
        campaignAdapter.itemListener(this)

        campaignRv.adapter = campaignAdapter
        campaignRv.layoutManager = layoutManager
    }

    fun init(view: View){
        campaignRv = view.findViewById(R.id.campaign_rv)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment campaignFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            campaignFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClicked(campaign: Campaign) {
        val goToActiviti = Intent(activity, DetailCampaignActivity::class.java)
        goToActiviti.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val str = Gson().toJson(campaign, Campaign::class.java)

        goToActiviti.putExtra( "extra", str)

        activity?.applicationContext?.startActivity(goToActiviti)
    }
}