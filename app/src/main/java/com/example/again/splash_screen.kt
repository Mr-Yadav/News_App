package com.example.again

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import com.example.again.databinding.ActivitySplashScreenBinding


class splash_screen : AppCompatActivity() {
    lateinit var binding2: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding2.root)



        Handler().postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
                finish()
            }, 500
        )


    }
}