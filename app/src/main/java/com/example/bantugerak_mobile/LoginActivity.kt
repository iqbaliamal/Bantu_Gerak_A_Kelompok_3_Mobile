package com.example.bantugerak_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.bantugerak_mobile.helper.SharedPref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var s:SharedPref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val register = findViewById<TextView>(R.id.link_register)
        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        s = SharedPref(this)

        btn_login.setOnClickListener {
//            Login()
            s.setStatusLogin(true)

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

//        pb.visibility = View.VISIBLE
//        ApiConfig.instanceRetrofit.loginapi(editTextEmail.text.toString(), editTextPassword.text.toString()).enqueue(object : Callback<ResponModel> {
//
//            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
//                pb.visibility = View.GONE
//                val respon =response.body()!!
//
//                if (respon.success == 1){
//                    s.setStatusLogin(true)
//                    s.setUser(respon.user)
//                    val intent = Intent(this@login, MainActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//                    startActivity(intent)
//                    finish()
//                    Toast.makeText(this@login, "Selamat datang "+respon.user.name, Toast.LENGTH_SHORT).show()
//                }
//                else{
//                    Toast.makeText(this@login, "Error : "+respon.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
//                pb.visibility = View.GONE
//                Toast.makeText(this@login, "Error : "+t.message, Toast.LENGTH_SHORT).show()
//            }
//
//        })

    }
}