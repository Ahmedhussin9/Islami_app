package com.example.islami.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.islami.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) :ViewModel(),SplashContract.ViewModel {
    private val _event =SingleLiveEvent<SplashContract.Event>()
    override var events: LiveData<SplashContract.Event> = _event
    fun loadEvents(){
        _event.postValue(SplashContract.Event.NavigateToHome)
    }

}
