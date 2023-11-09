package com.example.data.repository.QuranRepositoryImpl

import com.example.data.dataSourceContract.QuranDataSource
import com.example.domain.repositories.QuranRepository.QuranTitlesRepository
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    private val quranDataSource: QuranDataSource
):QuranTitlesRepository {
    override  fun getQuranTitles(): List<String> {
        return quranDataSource.getQuranDataSource()
    }
}