package com.cem.splashscreenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.cem.splashscreenapp.databinding.ActivityMainBinding
import com.cem.splashscreenapp.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val splashScreen = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation1 = AnimationUtils.loadAnimation(this, R.anim.animation1)
        val animation2 = AnimationUtils.loadAnimation(this, R.anim.animation2)
        val animation3 = AnimationUtils.loadAnimation(this, R.anim.animation3)

        binding.apply{
            lambOffImg.animation = animation1
            lambOnImg.animation = animation2
            baslik.animation = animation3
            aciklama.animation = animation3

            Handler().postDelayed({
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            },splashScreen.toLong())
        }

    }
}