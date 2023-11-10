package com.example.domain.repositories.HadethReostitory

import android.content.Context
import com.example.domain.model.Hadeth
import dagger.hilt.android.qualifiers.ApplicationContext

interface HadethRepository {
    fun getHadethList(@ApplicationContext context: Context):List<Hadeth>
}