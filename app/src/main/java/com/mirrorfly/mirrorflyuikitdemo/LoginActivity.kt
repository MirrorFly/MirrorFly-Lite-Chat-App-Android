package com.mirrorfly.mirrorflyuikitdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import com.mirrorfly.mirrorflyuikitdemo.databinding.ActivityLoginBinding
import com.mirrorfly.uikitsdk.MirrorFlyUIKit
import com.mirrorfly.uikitsdk.interfaces.InitResultHandler

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.register.setOnClickListener {

            if(binding.edtTxt.text!!.isNotEmpty()){
                registerAccount(binding.edtTxt.text!!.toString())
            }
            else{
                Toast.makeText(this, "Please enter the credentials", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun registerAccount(USER_IDENTIFIER:String) {

        MirrorFlyUIKit.initUser(this@LoginActivity,USER_IDENTIFIER, "*** Firebase Token ***", object : InitResultHandler {

            override fun onInitResponse(isSuccess: Boolean, e: String) {
                if (isSuccess) {
                    startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity,e, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}