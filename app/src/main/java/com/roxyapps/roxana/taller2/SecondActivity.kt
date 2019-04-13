package com.roxyapps.roxana.taller2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.roxyapps.roxana.taller2.models.DataCoin
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_container_layout.*
import kotlinx.android.synthetic.main.fragment_container_layout.view.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val uri:DataCoin = this.intent.extras.getParcelable<DataCoin>(AppConstants.TeXT_KEY)
        tvnombre.text=uri.name
        tvvalor.text= uri.value.toString()
        fun init(coin: DataCoin) {
            Glide.with(this)
                .load(coin.img)
                .placeholder(R.drawable.ic_launcher_background)
                .into(img_prin)
            Glide.with(this)
                .load(coin.img)
                .placeholder(R.drawable.ic_launcher_background)
                .into(cruz)
            Glide.with(this)
                .load(coin.img)
                .placeholder(R.drawable.ic_launcher_background)
                .into(cara)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item!!.itemId){
            android.R.id.home -> {onBackPressed();true}
            else -> super.onOptionsItemSelected(item)
        }
    }
}

