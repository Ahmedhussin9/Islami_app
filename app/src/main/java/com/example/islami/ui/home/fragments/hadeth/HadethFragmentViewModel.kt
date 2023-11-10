package com.example.islami.ui.home.fragments.hadeth

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.Hadeth
import com.example.domain.usecases.HadethFragmentUseCases.HadethFragmentUseCase
import com.example.islami.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class HadethFragmentViewModel @Inject constructor(
   private val useCase: HadethFragmentUseCase,
   @ApplicationContext val context: Context
) :ViewModel(),HadethFragmentContract.ViewModel {
    private val _state =MutableLiveData<HadethFragmentContract.State>()
    override val state: MutableLiveData<HadethFragmentContract.State> = _state
    private val _event = SingleLiveEvent<HadethFragmentContract.Event>()
    override val event: LiveData<HadethFragmentContract.Event> =_event
    fun loadHadethList(){
      val data: List<Hadeth> = useCase.invoke(context = context)
        _state.postValue(HadethFragmentContract.State.Success(data))
          }
    override fun invokeAction(action: HadethFragmentContract.Action) {
        when (action){
            is HadethFragmentContract.Action.LoadHadethList->loadHadethList()
            is HadethFragmentContract.Action.onHadethClick->navigateToHadethDetails(action.item)
        }
    }

    private fun navigateToHadethDetails(item:Hadeth) {
        _event.postValue(HadethFragmentContract.Event.NavigateToHadethDetails(item))
    }

}