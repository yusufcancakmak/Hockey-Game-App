package com.hockeystone22

import android.content.Intent
import android.content.pm.ActivityInfo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.hockeystone22.databinding.ActivitySettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        landscape()

        binding.imageviewHome4.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).start()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.info.setOnClickListener {
            binding.info.visibility=View.GONE
            binding.infoTwo!!.visibility=View.VISIBLE
            MediaPlayer.create(this,R.raw.itemonclikraw).stop()
        }
        binding.infoTwo?.setOnClickListener {
            binding.infoTwo!!.visibility=View.GONE
        binding.info.visibility=View.VISIBLE
        }

        binding.settings.setOnClickListener {

            //  if (isProtrait) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            binding.settings.visibility=View.GONE
            binding.diffsettings.visibility=View.VISIBLE
            //  } else {
            // requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        //   isProtrait = !isProtrait

        binding.diffsettings.setOnClickListener {

            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            binding.diffsettings.visibility=View.GONE
            binding.settings.visibility=View.VISIBLE
        }
    }

    private fun landscape() {
      //  var isProtrait = true



        }


}
