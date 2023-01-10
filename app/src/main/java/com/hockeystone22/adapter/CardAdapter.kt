package com.hockeystone22.adapter
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hockeystone22.R
import com.hockeystone22.databinding.CardItemBinding
import com.hockeystone22.model.Results
import com.hockeystone22.model.Topgoal

class CardAdapter() : RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)
    private lateinit var array:IntArray
    private lateinit var mydialog: AlertDialog

//RESPONSE'DAN DÖNEN VERİ LİST OFF DÖNDÜĞÜ İÇİN CAĞIRILAN VERİNİN LİSTE ŞEKLİNDE ALINABİLMESİ İÇİN CALLBACK VE KULLANDIĞI BÖLÜMLERİN BAŞINA LİST FONKSİYONU ÇAĞIRILIR.
    private val differutil = object : DiffUtil.ItemCallback<List<Topgoal>>() {
        override fun areItemsTheSame(oldItem: List<Topgoal>, newItem: List<Topgoal>): Boolean {
            return newItem[0].player.id==oldItem[0].player.id

        }

        override fun areContentsTheSame(oldItem: List<Topgoal>, newItem: List<Topgoal>): Boolean {
            return newItem == oldItem
        }


    }
    private val differ = AsyncListDiffer(this, differutil)
    var playerlist: List<List<Topgoal>>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentlist = playerlist[position]
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

        holder.binding.txtName.text = currentlist[0].player.name
        holder.binding.txtMatch.text = currentlist[0].matches.toString()
        holder.binding.txtMatchOne.text = currentlist[0].goals
        //Glide.with(holder.itemView.context)
          //  .load(array.random())
            //.into(holder.binding.imageViewPlayer)
       holder.binding.imageViewPlayer.setImageResource(array.random())
        holder.binding.txtName2.text = currentlist[1].player.name
        holder.binding.txtMatch2.text = currentlist[1].matches
        holder.binding.txtMatchTwo.text = currentlist[1].goals
       // Glide.with(holder.itemView.context)
        //    .load(array.random())
          //  .into(holder.binding.imageViewPlayer2)
        holder.binding.imageViewPlayer2.setImageResource(array.random())
        holder.binding.txtName3.text = currentlist[2].player.name
        holder.binding.txtMatchThree3.text = currentlist[2].matches
        holder.binding.txtMatchThree.text = currentlist[2].goals
       // Glide.with(holder.itemView.context)
         //   .load(array.random())
           // .into(holder.binding.imageViewPlayer3)
        holder.binding.imageViewPlayer3.setImageResource(array.random())
    }

    override fun getItemCount() = playerlist.size


}








