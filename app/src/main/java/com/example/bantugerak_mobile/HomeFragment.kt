package com.example.bantugerak_mobile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
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
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        // Inflate the layout for this fragment
        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://cdn1-production-images-kly.akamaized.net/Lp4ZMNdzQ89iphOeDwpz1A0UV5g=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2703835/original/060532300_1547463460-macam-macam_bencana_alam.jpg"))
        imageList.add(SlideModel("https://www.its.ac.id/news/wp-content/uploads/sites/2/2018/12/letusan-gunung-krakatau_20170923_174854.jpg"))
        imageList.add(SlideModel("https://apahabar.com/wp-content/uploads/2020/06/1e57a22c-c7a3-43fb-b7c4-ad3e5bdd11f8.jpg"))
        imageList.add(SlideModel("https://awsimages.detik.net.id/visual/2020/01/02/05686423-6018-4448-b20e-9cc415885723.png?w=650"))

        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        return view
//        return inflater.inflate(R.layout.fragment_home, container, false)
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