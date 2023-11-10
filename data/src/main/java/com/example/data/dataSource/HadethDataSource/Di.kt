package com.example.data.dataSource.HadethDataSource

import com.example.data.dataSourceContract.HadethDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Di {
    @Binds
    abstract fun provideHadethDataSource(
        hadethDataSourceImpl: HadethDataSourceImpl
    ):HadethDataSource
}