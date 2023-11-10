package com.example.data.dataSource.HadethDataSource

import android.content.Context
import com.example.data.dataSourceContract.HadethDataSource
import com.example.domain.model.Hadeth
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HadethDataSourceImpl @Inject constructor():HadethDataSource {
    override fun getHadethDataSource(@ApplicationContext context: Context): List<Hadeth> {
        val hadethList = mutableListOf<Hadeth>()
        val fileContent = context.assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val singleHadethList = fileContent.trim().split("#")
        singleHadethList.forEach { elemnt ->
            val lines = elemnt.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }
        return hadethList
    }
}