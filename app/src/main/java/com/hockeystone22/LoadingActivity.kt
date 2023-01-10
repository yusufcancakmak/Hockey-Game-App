package com.hockeystone22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.hockeystone22.databinding.ActivityLoadingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoadingActivity : AppCompatActivity() {
    val splashScreen=4000
    private lateinit var binding:ActivityLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animasyon1=AnimationUtils.loadAnimation(this,R.anim.loading_anim)
        val animasyon2=AnimationUtils.loadAnimation(this,R.anim.loading_anim2)
        val animasyon3=AnimationUtils.loadAnimation(this,R.anim.loading_anim3)
        val animasyon4=AnimationUtils.loadAnimation(this,R.anim.loading_anim4)

        binding.apply {
            loadingGroupOne.animation=animasyon1
            loadingGroupTwo.animation=animasyon2
            loadingGroupThree.animation=animasyon3
            loadingGroupFive.animation=animasyon4

            //SplashScrenn
            Handler().postDelayed({
                val intent=Intent(this@LoadingActivity,MainActivity::class.java)
                startActivity(intent)
            },splashScreen.toLong())
        }

    }
}