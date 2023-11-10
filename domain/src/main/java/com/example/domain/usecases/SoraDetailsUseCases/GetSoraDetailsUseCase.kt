package com.example.domain.usecases.SoraDetailsUseCases

import android.content.Context
import com.example.domain.repositories.SoraDetailsRepository.SoraDetailsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetSoraDetailsUseCase @Inject constructor(
    private val soraDetailsRepository: SoraDetailsRepository,
    @ApplicationContext val context: Context
) {
    fun invoke(context:Context,soraIndex:Int,name:String):List<String>{
         return soraDetailsRepository.getSoraDetails(context,soraIndex,name)
    }
}