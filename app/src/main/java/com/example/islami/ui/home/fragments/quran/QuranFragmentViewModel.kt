package com.example.islami.ui.home.fragments.quran

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecases.getQuranTitlesUseCase
import com.example.islami.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class QuranFragmentViewModel @Inject constructor(
    private val useCase: getQuranTitlesUseCase,
):ViewModel() ,QuranFragmentContract.ViewModel{
    private val _state =MutableLiveData<QuranFragmentContract.State>()
    override val state: MutableLiveData<QuranFragmentContract.State> = _state

    private val _event = SingleLiveEvent<QuranFragmentContract.Event>()
    override val event: LiveData<QuranFragmentContract.Event> =_event
    override fun invokeAction(action: QuranFragmentContract.Action) {
        when(action){
            is QuranFragmentContract.Action.loadQuranTitle->loadQuranTitles()
            is QuranFragmentContract.Action.onTitleClick->navigateToSoraDetails(action.position,action.name)
        }
    }
    fun navigateToSoraDetails(position:Int,name:String){
       _event.postValue(QuranFragmentContract.Event.NavigateToSoraDetails(position,name))
    }
    private fun loadQuranTitles(){
            val data =  useCase.invoke()
            _state.postValue(QuranFragmentContract.State.Success(data))
    }
}