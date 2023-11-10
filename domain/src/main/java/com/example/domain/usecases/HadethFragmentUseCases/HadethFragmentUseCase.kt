package com.example.domain.usecases.HadethFragmentUseCases

import android.content.Context
import com.example.domain.model.Hadeth
import com.example.domain.repositories.HadethReostitory.HadethRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HadethFragmentUseCase @Inject constructor(
    private val hadethRepository: HadethRepository,
    @ApplicationContext val context: Context
) {
    fun invoke(@ApplicationContext context: Context):List<Hadeth>{
        return hadethRepository.getHadethList(context)
    }
}