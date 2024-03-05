package com.dicoding.myfavoriteff7characters

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val mainIntent = Intent(
                this@SplashActivity,
                MainActivity::class.java
            )
            startActivity(mainIntent)
            finish()
        }, SPLASH_TIMEOUT.toLong())
    }

    companion object {
        private const val SPLASH_TIMEOUT = 2000
    }
}

