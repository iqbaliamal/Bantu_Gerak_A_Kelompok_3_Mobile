package com.example.bantugerak_mobile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.R
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.bantugerak_mobile.adapter.AdapterCampaign
import com.example.bantugerak_mobile.model.Campaign
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var rVCqmpaign:RecyclerView

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
    ): View? {
        val view: View = inflater.inflate(com.example.bantugerak_mobile.R.layout.fragment_home, container, false)

        rVCqmpaign = view.findViewById(com.example.bantugerak_mobile.R.id.rv_campaign)

        // Inflate the layout for this fragment
        val imageSlider = view.findViewById<ImageSlider>(com.example.bantugerak_mobile.R.id.image_slider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://cdn1-production-images-kly.akamaized.net/Lp4ZMNdzQ89iphOeDwpz1A0UV5g=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2703835/original/060532300_1547463460-macam-macam_bencana_alam.jpg"))
        imageList.add(SlideModel("https://www.its.ac.id/news/wp-content/uploads/sites/2/2018/12/letusan-gunung-krakatau_20170923_174854.jpg"))
        imageList.add(SlideModel("https://apahabar.com/wp-content/uploads/2020/06/1e57a22c-c7a3-43fb-b7c4-ad3e5bdd11f8.jpg"))
        imageList.add(SlideModel("https://awsimages.detik.net.id/visual/2020/01/02/05686423-6018-4448-b20e-9cc415885723.png?w=650"))

        imageSlider.setImageList(imageList,ScaleTypes.FIT)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL


        rVCqmpaign.adapter = AdapterCampaign(requireActivity(),arrCampaign)
        rVCqmpaign.layoutManager = layoutManager


        return view
//        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    val arrCampaign: ArrayList<Campaign>get() {
        val arr = ArrayList<Campaign>()
        val c1 = Campaign()
        c1.gambar = com.example.bantugerak_mobile.R.drawable.gunung
        c1.title = "Galang dana untuk bencana"
        c1.penggalang = "Iqbal Ikhlasul Amal"
        c1.danaSementara = "Rp.80.000.000"
        c1.terkumpultxt = "Terkumpul dari"
        c1.target = "Rp.90.000.000"
        c1.maxDate = "16"
        c1.hariLagi = "Hari Lagi"
        c1.cerita = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

        val c2 = Campaign()
        c2.gambar = com.example.bantugerak_mobile.R.drawable.circle_logo
        c2.title = "Galang dana untuk bencana"
        c2.penggalang = "Boby"
        c2.danaSementara = "Rp.11.000.000"
        c2.terkumpultxt = "Terkumpul dari"
        c2.target = "Rp.20.000.000"
        c2.maxDate = "16"
        c2.hariLagi = "Hari Lagi"
        c2.cerita = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

        val c3 = Campaign()
        c3.gambar = com.example.bantugerak_mobile.R.drawable.gunung
        c3.title = "Galang dana untuk bencana"
        c3.penggalang = "Feby"
        c3.danaSementara="Rp.6.000.000"
        c3.terkumpultxt = "Terkumpul dari"
        c3.target = "Rp.10.000.000"
        c3.maxDate = "16"
        c3.hariLagi = "Hari Lagi"
        c3.cerita = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

        arr.add(c1)
        arr.add(c2)
        arr.add(c3)

        return arr
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}