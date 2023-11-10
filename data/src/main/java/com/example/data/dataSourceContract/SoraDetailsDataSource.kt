package com.example.data.dataSourceContract

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

interface SoraDetailsDataSource {
    fun getSoraDetailsDataSource(@ApplicationContext context:Context,soraIndex:Int,name:String):List<String>
}