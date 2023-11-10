package com.example.data.repository.HadethReositoryImpl

import android.content.Context
import com.example.data.dataSourceContract.HadethDataSource
import com.example.domain.model.Hadeth
import com.example.domain.repositories.HadethReostitory.HadethRepository
import javax.inject.Inject

class HadethReposiotyImpl @Inject constructor(
  private val hadethDataSource: HadethDataSource
):HadethRepository{
    override fun getHadethList(context: Context): List<Hadeth> {
       return hadethDataSource.getHadethDataSource(context)
    }

}