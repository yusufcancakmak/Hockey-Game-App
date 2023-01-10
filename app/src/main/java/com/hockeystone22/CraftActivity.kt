package com.hockeystone22

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hockeystone22.adapter.CardAdapter
import com.hockeystone22.adapter.SetChooseAdapter
import com.hockeystone22.databinding.ActivityCraftBinding
import com.hockeystone22.helper.CraftHelper
import com.hockeystone22.model.LocalFootbalItem
import com.hockeystone22.viewmodel.HockeyPlayerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CraftActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCraftBinding
    private lateinit var setChooseAdapter: SetChooseAdapter
    private lateinit var cardAdapter: CardAdapter
    private  var array= intArrayOf()
    private var savecard = mutableListOf<LocalFootbalItem>()
    private val viewmodell: HockeyPlayerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCraftBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setChooseAdapter = SetChooseAdapter()
        cardAdapter = CardAdapter()
        getselectitem()
        startGetItem()

        binding.home.setOnClickListener {
            MediaPlayer.create(this,R.raw.itemonclikraw).start()
            val intent = Intent(this, MainActivity::class.java)
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

    @SuppressLint("MissingInflatedId")
    private fun getselectitem() {
        val builder = AlertDialog.Builder(this)
        val diaologView = LayoutInflater.from(this)
            .inflate(R.layout.popup_choose_card, null, false)
        val cancel = diaologView.findViewById<ImageView>(R.id.choose_close)
        val recyclerview_choose =
            diaologView.findViewById<RecyclerView>(R.id.recycler_view_choose)
        val alerDialogg = builder.create()
        alerDialogg.setView(diaologView)
        cancel.setOnClickListener {
            alerDialogg.dismiss()
        }
        binding.chooseSelect.setOnClickListener {
            alerDialogg.dismiss()

            recyclerview_choose.apply {
                layoutManager = LinearLayoutManager(it.rootView.context)
                adapter = setChooseAdapter


            }
            setChooseAdapter.indexthose = 0

            lifecycleScope.launchWhenStarted {
                viewmodell.getSavedPlayer().collect { data ->
                    setChooseAdapter.favoritesListt = data.chunked(3)
                }
            }

            alerDialogg.show()


        }




        binding.chooseSelectTwo.setOnClickListener {
            alerDialogg.dismiss()
            val recyclerview_choose =
                diaologView.findViewById<RecyclerView>(R.id.recycler_view_choose)
            val cons = diaologView.findViewById<ConstraintLayout>(R.id.popup_choose_cons)


            recyclerview_choose.apply {
                layoutManager = LinearLayoutManager(it.rootView.context)
                adapter = setChooseAdapter
            }
            setChooseAdapter.indexthose = 1
            lifecycleScope.launchWhenStarted {
                viewmodell.getSavedPlayer().collect { data ->
                    setChooseAdapter.favoritesListt = data.chunked(3)
                }
            }


            alerDialogg.show()


        }


        setChooseAdapter.setOnClickListener { item, index, index2 ->
            if (CraftHelper.selectedNumberList.contains(index2))
                return@setOnClickListener
            CraftHelper.selectedNumberList.add(index2)
            alerDialogg.dismiss()

            when (index) {
                0 -> {
                    MediaPlayer.create(this,R.raw.card_open).start()
                    binding.imageChoseYellowcard.visibility = View.VISIBLE
                    binding.txtChooseName.visibility = View.VISIBLE
                    binding.txtChooseMatch.visibility = View.VISIBLE
                    binding.txtChooseFord.visibility = View.VISIBLE
                    binding.txtChooseStar.visibility = View.VISIBLE
                    binding.imageviewChooseOne.visibility = View.VISIBLE
                    binding.txtChooseName.text = item.name.toString()
                    binding.txtChooseMatch.text = item.matches.toString()
                    binding.txtChooseFord.text = item.formattedValue.toString()
                    Glide.with(this).load(item.imageDrawable).into(binding.imageviewChooseOne)
                }
                1 -> {
                    MediaPlayer.create(this,R.raw.card_open).start()
                    binding.imageChooseBlue.visibility = View.VISIBLE
                    binding.txtChooseNameTwo.visibility = View.VISIBLE
                    binding.txtChooseMatchTwo.visibility = View.VISIBLE
                    binding.txtChooseFordTwo.visibility = View.VISIBLE
                    binding.txtChooseStarTwo.visibility = View.VISIBLE
                    binding.imageviewChooseTwo.visibility = View.VISIBLE
                    binding.txtChooseName.text = item.name.toString()
                    binding.txtChooseMatch.text = item.matches.toString()
                    binding.txtChooseFord.text = item.formattedValue.toString()
                    Glide.with(this).load(item.imageDrawable).into(binding.imageviewChooseTwo)

                }

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        CraftHelper.clear()
    }

    private fun startGetItem() {

        binding.startItem.setOnClickListener {
            MediaPlayer.create(this,R.raw.card_open).start()

            binding.apply {
                chooseImageGreen.visibility = View.VISIBLE
                txtChooseNameTwoRandom.visibility = View.VISIBLE
                txtChooseMatchTwoRandom.visibility = View.VISIBLE
                txtChooseFordRandom.visibility = View.VISIBLE
                txtChooseStarTwoRandom.visibility = View.VISIBLE
                randomImageviewCardChoose.visibility = View.VISIBLE


            }
            viewmodell.getallplayerviewModel()
            viewmodell.gethockeylist.observe(this, Observer { data ->
                data.shuffled().take(1).forEachIndexed { index, topPlayer ->
                //data.shuffled().take(1).forEachIndexed { index, topPlayer ->
                    savecard.add(
                        LocalFootbalItem(
                            name = topPlayer.player.name,
                            matches = topPlayer.matches.toInt(),
                            formattedValue = topPlayer.goals,
                            imageDrawable = array.random(),
                            platerId = topPlayer.player.id.toInt()
                        )
                    )
                }
                binding.txtChooseNameTwoRandom.text =
                    savecard.get(0).name.toString()
                binding.txtChooseMatchTwoRandom.text =
                    savecard.get(0).matches.toString()
                binding.txtChooseFordRandom.text =
                    savecard.get(0).formattedValue
                Glide.with(this)
                   .load(savecard.get(0).imageDrawable)
                    .into(binding.randomImageviewCardChoose)
              //  binding.randomImageviewCardChoose.setImageResource(array.random())

                savecard.forEach {
                    viewmodell.insertPlayer(savecard)


                }



                binding.startItem.visibility = View.GONE
                binding.chooseConfirm.visibility = View.VISIBLE


            })
        }
        binding.chooseConfirm.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}