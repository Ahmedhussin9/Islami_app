package com.example.data.repository.HadethReositoryImpl

import com.example.domain.repositories.HadethReostitory.HadethRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Di {
    @Binds
    abstract fun provideHadethRepsitory(
        hadethReposiotyImpl: HadethReposiotyImpl
    ):HadethRepository
}