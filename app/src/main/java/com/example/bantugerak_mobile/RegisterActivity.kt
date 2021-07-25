package com.example.bantugerak_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.bantugerak_mobile.app.ApiConfig
import com.example.bantugerak_mobile.helper.SharedPref
import com.example.bantugerak_mobile.model.ResponModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.pb
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    lateinit var s:SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide()

        s = SharedPref(this)

        val login = findViewById<TextView>(R.id.link_login)
        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        register_btn.setOnClickListener {
            register()
        }

        dataDummy()
    }

    fun dataDummy() {
        reg_name.setText("coba")
        reg_email.setText("coba@gmail.com")
        reg_password.setText("coba")
        reg_password_confirm.setText("coba")
    }


    fun register(){
        if (reg_name.text.isEmpty()){
            reg_name.error = "Kolom tidak boleh kosong !"
            reg_name.requestFocus()
            return
        } else if (reg_email.text.isEmpty()){
            reg_email.error = "Kolom email tidak boleh kosong !"
            reg_email.requestFocus()
            return
        } else if (reg_password.text.isEmpty()){
            reg_password.error = "Kolom password tidak boleh kosong !"
            reg_password.requestFocus()
            return
        } else if (reg_password_confirm.text.isEmpty()){
            reg_password_confirm.error = "Kolom confirm password tidak boleh kosong !"
            reg_password_confirm.requestFocus()
            return
        }

        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.register(
            reg_name.text.toString(),
            reg_email.text.toString(),
            reg_password.text.toString(),
            reg_password_confirm.text.toString()).enqueue(object : Callback<ResponModel> {

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                // Handle ketika gagal
                pb.visibility = View.GONE

                Toast.makeText(this@RegisterActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                //Handle ketika berhasil

//                override fun onFailure(call: Call<ResponModel>, t: Throwable) {
//                    pb.visibility = View.GONE
//                    Toast.makeText(this@RegisterActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
//                }

                pb.visibility = View.GONE

                val r = response.body()
                if (r?.success == 1){
                    s.setStatusLogin(true)
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this@RegisterActivity, "Selamat datang " + r.data.name, Toast.LENGTH_SHORT).show()
                }
                else{
                    val gson = Gson()
                    val type = object : TypeToken<ResponModel>() {}.type
                    var errorResponse: ResponModel? = gson.fromJson(response.errorBody()!!.charStream(), type)

                    //Retriving just message
                    Toast.makeText(this@RegisterActivity, errorResponse?.message, Toast.LENGTH_SHORT).show()
//                    Toast.makeText(this@RegisterActivity, "Error : " + r.message, Toast.LENGTH_SHORT).show()
                }
            }


        })

    }

}