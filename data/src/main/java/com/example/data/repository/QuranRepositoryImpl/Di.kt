package com.example.data.repository.QuranRepositoryImpl

import com.example.domain.repositories.QuranRepository.QuranTitlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {
    @Binds
    abstract fun provideQuranRepository(quranRepositoryImpl: QuranRepositoryImpl):QuranTitlesRepository
}