package com.example.data.dataSource

import com.example.data.dataSourceContract.QuranDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class di {
    @Binds
    abstract fun provideQuranDataSource(
        quranDataSourceImpl: QuranDataSourceImpl
    ):QuranDataSource
}