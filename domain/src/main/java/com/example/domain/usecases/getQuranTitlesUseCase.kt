package com.example.domain.usecases

import com.example.domain.repositories.QuranRepository.QuranTitlesRepository
import javax.inject.Inject

class getQuranTitlesUseCase @Inject constructor(
    private val quranTitlesRepository: QuranTitlesRepository ){
     fun invoke():List<String>{
        return quranTitlesRepository.getQuranTitles()
    }
}