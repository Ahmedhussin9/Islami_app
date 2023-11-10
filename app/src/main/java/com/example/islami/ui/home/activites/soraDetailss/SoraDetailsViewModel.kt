package com.example.islami.ui.home.activites.soraDetailss
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecases.SoraDetailsUseCases.GetSoraDetailsUseCase
import com.example.islami.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
@HiltViewModel
class SoraDetailsViewModel @Inject constructor(
   private val useCase: GetSoraDetailsUseCase,
   @ApplicationContext val context: Context,
) :ViewModel(),SoraDetailsContract.ViewModel{
   lateinit var soraName:String
   var soraIndex:Int = 0
   private val _state = MutableLiveData<SoraDetailsContract.State>()
   override val state: MutableLiveData<SoraDetailsContract.State> = _state
   private val _event = SingleLiveEvent<SoraDetailsContract.Event>()
   override val event: LiveData<SoraDetailsContract.Event> = _event

   private fun loadSoraDetails() {
      val data =useCase.invoke(context,soraIndex,soraName)
      _state.postValue(SoraDetailsContract.State.Success(data))
   }

   override fun invokeAction(action: SoraDetailsContract.Action) {
      when (action){
         is SoraDetailsContract.Action.PassPramasToViewModel->initParams(action)

         is SoraDetailsContract.Action.loadSoraDetils -> loadSoraDetails()
      }
   }

   private fun initParams(action: SoraDetailsContract.Action.PassPramasToViewModel) {
      soraIndex = action.soraIndex
      soraName = action.soraName
   }

}