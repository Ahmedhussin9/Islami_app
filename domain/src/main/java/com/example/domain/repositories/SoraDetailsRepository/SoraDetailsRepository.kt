package com.example.domain.repositories.SoraDetailsRepository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

interface SoraDetailsRepository {
    fun getSoraDetails(@ApplicationContext context: Context,soraIndex:Int,name:String):List<String>
}