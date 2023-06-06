package com.zireddinismayilov.vehicleapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, 2000)
    }
}