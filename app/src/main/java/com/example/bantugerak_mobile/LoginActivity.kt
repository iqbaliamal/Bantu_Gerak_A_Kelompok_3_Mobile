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
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        supportActionBar?.hide()

        val register = findViewById<TextView>(R.id.link_register)
        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        s = SharedPref(this)

        btn_login.setOnClickListener {
            Login()
//            s.setStatusLogin(true)

        }

    }

    fun Login(){
        if (edtText_email.text.isEmpty()){
            edtText_email.error = "Email tidak boleh kosong !"
            edtText_email.requestFocus()
            return
        } else if (edtText_password.text.isEmpty()){
            edtText_password.error = "Password tidak boleh kosong !"
            edtText_password.requestFocus()
            return
        } else {
            s.setStatusLogin(true)
        }

        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.login(edtText_email.text.toString(), edtText_password.text.toString()).enqueue(object : Callback<ResponModel> {

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                pb.visibility = View.GONE

                val respon = response.body()

//                val respon = response.code()

                if (respon?.success == 1){
                    s.setStatusLogin(true)
                    respon.let { s.setUser(it.data) }
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this@LoginActivity, "Selamat datang "+respon.data.name, Toast.LENGTH_SHORT).show()
                }
                else {
                    val gson = Gson()
                    val type = object : TypeToken<ResponModel>() {}.type
                    var errorResponse: ResponModel? = gson.fromJson(response.errorBody()!!.charStream(), type)

                    //Retriving just message
                    Toast.makeText(this@LoginActivity, errorResponse?.message, Toast.LENGTH_SHORT).show()

//                    if (respon != null) {
//                        Toast.makeText(this@LoginActivity, "Error : " + respon.message_login, Toast.LENGTH_SHORT).show()
//                    } else {
//                        Toast.makeText(this@LoginActivity, "Error : Login Failed", Toast.LENGTH_SHORT).show()
//                    }
                }
            }
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@LoginActivity, "Error : " + t.message , Toast.LENGTH_SHORT).show()
            }
        })
    }
}

