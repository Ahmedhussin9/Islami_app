package com.example.data.repository.SoraDetailsRepositoryImpl

import android.content.Context
import com.example.domain.repositories.SoraDetailsRepository.SoraDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun provideSoraDetailsRepository(
        soraDetailsRepositoryImpl: SoraDetailsRepositoryImpl,
    ):SoraDetailsRepository
    @Binds
    abstract fun provideContext(
        @ApplicationContext context: Context
    ):Context
}