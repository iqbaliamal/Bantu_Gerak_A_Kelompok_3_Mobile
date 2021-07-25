package com.example.bantugerak_mobile.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import com.example.bantugerak_mobile.DonasiActivity
import com.example.bantugerak_mobile.LoginActivity
import com.example.bantugerak_mobile.R
import com.example.bantugerak_mobile.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [profileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class profileFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btn_logout: RelativeLayout
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView
    lateinit var btnRiwayat: RelativeLayout



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
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_profile, container, false)

        init(view)
        s = SharedPref(requireActivity())
        btnLogout()
        btnRiwayat()
        setData()

        return view
    }

    private fun setData() {
        if (s.getUser() == null){
            val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            return
        }


        val data = s.getUser()!!

        tvNama.text = data.name
        tvEmail.text = data.email
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment profileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            profileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun btnLogout() {
        btn_logout.setOnClickListener {
            s.setStatusLogin(status = false)
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
    }

    private fun btnRiwayat(){
        btnRiwayat.setOnClickListener {
            val fragmentB = donationFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, fragmentB, "donationFragment")
                    .commit()
        }
    }

    private fun init(view: View) {
        btn_logout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_Nama)
        tvEmail = view.findViewById(R.id.tv_Email)
        btnRiwayat = view.findViewById(R.id.btn_riwayat)
    }

}