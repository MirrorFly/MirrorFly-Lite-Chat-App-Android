package com.mirrorfly.mirrorflyuikitdemo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.mirrorfly.mirrorflyuikitdemo.databinding.ActivitySplashBinding
import com.mirrorfly.uikitsdk.MirrorFlyUIKit
import com.mirrorfly.uikitsdk.utils.Constants
import com.mirrorfly.uikitsdk.utils.FlyInitializeSDKCallback
import com.mirrorfly.uikitsdk.utils.SharedPreferenceManager
import com.mirrorflysdk.api.ChatManager

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            initializeSDK()
        }, 2000)

    }

    private fun initializeSDK() {
        MirrorFlyUIKit.initializeSDK(this@SplashActivity, SplashActivity::class.java, "*** Enter Your license key ***", object : FlyInitializeSDKCallback {

            override fun flyError(isSuccess: Boolean, throwable: Throwable?, data: HashMap<String, Any>) {
                Log.d("flyError", "flyError() called with: isSuccess = $isSuccess, throwable = $throwable, data = $data")
            }

            override fun redirectToDashBoard(isSuccess: Boolean) {
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
            }

            override fun redirectToLogin(isSuccess: Boolean) {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }
        })
    }
}