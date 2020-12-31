package com.example.msgshareapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.msgshareapp.model.Hobby
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter( val context: Context,  private val hobbies: List<Hobby>): RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    companion object{
        val Tag: String = HobbiesAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title + " Clicked !")
                }

                itemView.imgShare.setOnClickListener {

                    currentHobby?.let {
                        val message: String = "You can plan for " + currentHobby!!.title

                        val intent = Intent()
                        intent.action = Intent.ACTION_SEND
                        intent.putExtra(Intent.EXTRA_TEXT, message)
                        intent.type = "text/plain"

                        context.startActivity(Intent.createChooser(intent, "Please select where you want to share: "))
                    }
                }
            }
        }

        fun setData(hobby: Hobby?, pos: Int){
            hobby?.let {
                itemView.txvTitle.text = hobby.title
            }

            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}