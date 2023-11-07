package com.example.islami.ui.splash

import androidx.lifecycle.LiveData

class SplashContract {
    interface ViewModel{
        var events:LiveData<Event>
    }
    sealed class Event{
         object NavigateToHome:Event()
    }
}