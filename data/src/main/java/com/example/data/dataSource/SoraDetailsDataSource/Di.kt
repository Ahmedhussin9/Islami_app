package com.example.data.dataSource.SoraDetailsDataSource

import com.example.data.dataSourceContract.SoraDetailsDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun provideSoraDetailsDataSource(
        soraDetailsDataSourceImpl: SoraDetailsDataSourceImpl
    ):SoraDetailsDataSource
}