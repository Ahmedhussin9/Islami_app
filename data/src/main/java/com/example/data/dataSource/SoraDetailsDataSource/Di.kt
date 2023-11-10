package com.example.data.dataSource.SoraDetailsDataSource

import android.content.Context
import com.example.data.dataSourceContract.SoraDetailsDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun provideSoraDetailsDataSource(
        soraDetailsDataSourceImpl: SoraDetailsDataSourceImpl,
    ):SoraDetailsDataSource

}