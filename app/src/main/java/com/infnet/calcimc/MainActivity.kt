package com.infnet.calcimc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

       var btn = findViewById<Button>(R.id.btn_login)
       var email = findViewById<EditText>(R.id.user_email)
       var pwd = findViewById<EditText>(R.id.user_password)

       btn?.setOnClickListener {

           this.login(email.toString(), pwd.toString())


       }

    }

    fun login(Email: String, Pwd: String){

        var intent = Intent(this, Dashboard::class.java)

        intent.putExtra("user_email", Email)
        intent.putExtra("user_password", Pwd)

        startActivity(intent)

    }

}

public class User(Email: String, Pwd: String)

