package com.hockeystone22

import android.content.Intent
import android.graphics.Bitmap
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils

import androidx.activity.viewModels

import androidx.lifecycle.Observer
import com.bumptech.glide.Glide


import com.hockeystone22.databinding.ActivityOpenBinding
import com.hockeystone22.helper.CraftHelper
import com.hockeystone22.model.LocalFootbalItem
import com.hockeystone22.viewmodel.HockeyPlayerViewModel
import com.nostra13.universalimageloader.core.ImageLoader
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OpenActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOpenBinding
    private val randofootballist = mutableListOf<LocalFootbalItem>()



    private var player = mutableListOf(R.drawable.two,
        R.drawable.three, R.drawable.four,R.drawable.five, R.drawable.six,R.drawable.seven,
        R.drawable.egiht,R.drawable.nine,R.drawable.ten,R.drawable.twelve, R.drawable.eleven,
        R.drawable.thirteen,R.drawable.fourteen,R.drawable.fiveteen, R.drawable.sixteen,R.drawable.seveneen,
        R.drawable.eightteen, R.drawable.nineteen,R.drawable.twenty, R.drawable.twentytwo,R.drawable.twentythree,
        R.drawable.twentyfour,R.drawable.twentyfive, R.drawable.twentysix, R.drawable.twentyseven,R.drawable.twentyeight,
        R.drawable.twentynine,R.drawable.thirty,R.drawable.thirtyone,R.drawable.thirtytwo,R.drawable.thirtythree,R.drawable.thirtyfour,
        R.drawable.thirtyfive,R.drawable.thirtyfive,R.drawable.thirtysix,R.drawable.thirtyseven,R.drawable.thirtyeight,R.drawable.thirtynine,
        R.drawable.fourty,R.drawable.fourtytwo,R.drawable.fourtythree,R.drawable.fourtyfour,R.drawable.fourtyfive,R.drawable.fourtysix,R.drawable.fourtyseven,
        R.drawable.fourtyegiht,R.drawable.fourtynine,R.drawable.fifty)
    private val mviewmodel:HockeyPlayerViewModel by viewModels()
    private var array= intArrayOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOpenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        scaleballfun()
        emptycard()
        binding.imageviewHome3.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).start()
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        binding.txtNext.setOnClickListener {
            randofootballist.let { veri ->
                mviewmodel.insertPlayer(veri)


            }
            val intent = Intent(this, CollectionsActivity::class.java)
            startActivity(intent)
            finish()
        }

          array = intArrayOf(R.drawable.one,
            R.drawable.two,
            R.drawable.three, R.drawable.four,R.drawable.five, R.drawable.six,R.drawable.seven,
             R.drawable.egiht,R.drawable.nine,R.drawable.ten,R.drawable.twelve, R.drawable.eleven,
             R.drawable.thirteen,R.drawable.fourteen,R.drawable.fiveteen, R.drawable.sixteen,R.drawable.seveneen,
             R.drawable.eightteen, R.drawable.nineteen,R.drawable.twenty, R.drawable.twentytwo,R.drawable.twentythree,
            R.drawable.twentyfour,R.drawable.twentyfive, R.drawable.twentysix, R.drawable.twentyseven,R.drawable.twentyeight,
         R.drawable.twentynine,R.drawable.thirty,R.drawable.thirtyone,R.drawable.thirtytwo,R.drawable.thirtythree,R.drawable.thirtyfour,
             R.drawable.thirtyfive,R.drawable.thirtyfive,R.drawable.thirtysix,R.drawable.thirtyseven,R.drawable.thirtyeight,R.drawable.thirtynine,
             R.drawable.fourty,R.drawable.fourtytwo,R.drawable.fourtythree,R.drawable.fourtyfour,R.drawable.fourtyfive,R.drawable.fourtysix,R.drawable.fourtyseven,
             R.drawable.fourtyegiht,R.drawable.fourtynine,R.drawable.fifty)




    }
    private fun scaleballfun() {
        binding.constranitlayoutt.apply {
            val aanimation = AnimationUtils.loadAnimation(this@OpenActivity, R.anim.scaleball)
            animation = aanimation
            setOnClickListener {
                aanimation.cancel()
                aanimation.reset()
                binding.constraintLayout3.visibility = View.GONE
                binding.linearArrowUp.visibility = View.GONE
                binding.linearArrowDown.visibility = View.GONE
                binding.constCard.visibility = View.VISIBLE
                binding.textView.visibility=View.GONE

            }

        }
    }
    private fun emptycard() {
      //  val r1=(player).shuffled().first()
        mviewmodel.getallplayerviewModel()
        mviewmodel.gethockeylist.observe(this, Observer { data ->
            data.shuffled().take(3).forEachIndexed { index, footballItem ->

                randofootballist.add(
                    LocalFootbalItem(
                       // name = footballItem.player.name.toString(),
                       // matches = footballItem.matches.toInt(),
                      //  formattedValue = footballItem.goals,
                      //  imageDrawable = array.random(),
                      //  platerId = footballItem.player.id.toInt()
                        name = footballItem.player.name.toString(),
                        matches = footballItem.matches.toInt(),
                        formattedValue = footballItem.goals,
                        imageDrawable = array.random(),
                        platerId = footballItem.player.id.toInt()
                    )
                )
            }
        })

        binding.imageViewcardtwo.setOnClickListener {
            MediaPlayer.create(this,R.raw.card_open).start()
            if (randofootballist.isEmpty())
                return@setOnClickListener
            CraftHelper.lastNumOfDrawable+=1
            // MediaPlayer.create(this,R.raw.card_open).start()
            binding.imageViewcardtwo.visibility = View.GONE
            binding.constCardTwo.visibility = View.VISIBLE
            binding.imageViewcardGreen.visibility = View.VISIBLE
            binding.txtNameTwo.visibility = View.VISIBLE
            binding.txtRandomOneMatch2.visibility = View.VISIBLE
            binding.txtRandomOneMatch3.visibility = View.VISIBLE
            binding.txtStar2.visibility = View.VISIBLE
            binding.imageViewCardOne2.visibility = View.VISIBLE


            binding.txtNameTwo.text = randofootballist.get(0).name
            binding.txtRandomOneMatch2.text =
                randofootballist.get(0).matches.toString()
            binding.txtRandomOneMatch3.text =
                randofootballist.get(0).formattedValue.toString()
           // Glide.with(this).load(array.random()).into(binding.imageViewCardOne2)
            binding.imageViewCardOne2.setImageResource(array.random())


        }
        binding.imageViewcardthree.setOnClickListener {
            MediaPlayer.create(this,R.raw.card_open).start()
            if (randofootballist.isEmpty())
                return@setOnClickListener
            CraftHelper.lastNumOfDrawable+=1
            //  MediaPlayer.create(this,R.raw.card_open).start()
            binding.imageViewcardthree.visibility = View.GONE
            binding.constCardTwo.visibility = View.VISIBLE
            binding.imageViewcardBlue.visibility = View.VISIBLE
            binding.txtNameThree.visibility = View.VISIBLE
            binding.txtRandomOneMatch4.visibility = View.VISIBLE
            binding.txtRandomOneMatch5.visibility = View.VISIBLE
            binding.txtStar3.visibility = View.VISIBLE
            binding.imageViewCardOne3.visibility = View.VISIBLE

            binding.txtNameThree.text =
                randofootballist.get(1).name.toString()
            binding.txtRandomOneMatch4.text =
                randofootballist.get(1).matches.toString()
            binding.txtRandomOneMatch5.text =
                randofootballist.get(1).formattedValue.toString()
          binding.imageViewCardOne3.setImageResource(array.random())

        }


        binding.imagecardone.setOnClickListener {
            MediaPlayer.create(this,R.raw.card_open).start()
            if (randofootballist.isEmpty())
                return@setOnClickListener
            CraftHelper.lastNumOfDrawable+=1
            // MediaPlayer.create(this,R.raw.card_open).start()
            binding.imagecardone.visibility = View.GONE
            binding.constCardTwo.visibility = View.VISIBLE
            binding.imagecardYellow.visibility = View.VISIBLE
            binding.txtNameOne.visibility = View.VISIBLE
            binding.txtDegerGoster.visibility = View.VISIBLE
            binding.txtMatchOneDeger.visibility = View.VISIBLE
            binding.txtStar.visibility = View.VISIBLE
            binding.imageViewCardOne.visibility = View.VISIBLE
            binding.txtNext.visibility=View.VISIBLE

            binding.txtNameOne.text = randofootballist.get(2).name.toString()
            binding.txtDegerGoster.text = randofootballist.get(2).matches.toString()
            binding.txtMatchOneDeger.text = randofootballist.get(2).formattedValue.toString()
            binding.imageViewCardOne.setImageResource(array.random())


        }
    }

   /* private suspend fun getBitMap():Bitmap{

        val imageLoader  =ImageLoader.getInstance()
        imageLoader.displayImage(R.drawable.eleven)


    }*/












}


