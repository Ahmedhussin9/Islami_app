package com.example.data.dataSourceContract

import android.content.Context

import com.example.domain.model.Hadeth
import dagger.hilt.android.qualifiers.ApplicationContext

interface HadethDataSource {
    fun getHadethDataSource(@ApplicationContext context: Context):List<Hadeth>
}