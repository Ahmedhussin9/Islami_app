package com.example.data.repository.SoraDetailsRepositoryImpl

import android.content.Context
import com.example.data.dataSource.SoraDetailsDataSource.SoraDetailsDataSourceImpl
import com.example.data.dataSourceContract.SoraDetailsDataSource
import com.example.domain.repositories.SoraDetailsRepository.SoraDetailsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SoraDetailsRepositoryImpl @Inject constructor(
    private val soraDetailsDataSource: SoraDetailsDataSource
):SoraDetailsRepository {
    override fun getSoraDetails(@ApplicationContext context: Context,soraIndex: Int, name: String): List<String> {
        return soraDetailsDataSource.getSoraDetailsDataSource(context,soraIndex,name)
    }
}