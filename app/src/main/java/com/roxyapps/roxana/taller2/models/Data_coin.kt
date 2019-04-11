package com.roxyapps.roxana.taller2.models

data class Data_coin(
    val name:String,
    val country:String,
    val value:Number,
    val value_us:Number,
    val year:Number,
    val review: String,
    val isAvailable:Boolean,
    val img:String
)