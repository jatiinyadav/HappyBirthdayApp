package com.example.msgshareapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.R
import com.example.msgshareapp.model.Constants
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity(){

    companion object{
        val Tag: String = SecondActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = "HAPPY BIRTHDAY      " +  bundle.getString(Constants.USER_MSG_KEY)

            showToast("Happy Birthday!!")

            txvUserMessage.text = msg
        }

    }
}