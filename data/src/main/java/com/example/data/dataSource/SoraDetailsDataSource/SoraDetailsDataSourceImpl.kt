package com.example.data.dataSource.SoraDetailsDataSource

import android.content.Context
import com.example.data.dataSourceContract.SoraDetailsDataSource
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SoraDetailsDataSourceImpl @Inject constructor():SoraDetailsDataSource {
    override fun getSoraDetailsDataSource(
       @ApplicationContext context: Context,
        soraIndex: Int,
        name: String
    ): List<String> {
        val fileContent =context.assets.open("$soraIndex.txt").bufferedReader().use { it.readText() }
        val lines= fileContent.trim().split("\n")
        return lines
    }
}