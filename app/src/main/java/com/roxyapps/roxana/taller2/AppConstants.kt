package com.roxyapps.roxana.taller2

import com.roxyapps.roxana.taller2.models.DataCoin

class AppConstants {
    companion object {
        val TeXT_KEY = "textKey"
    }
    interface MyCoinAdapter {
        fun changeDataSet(newDataSet : List<DataCoin>)
    }
}