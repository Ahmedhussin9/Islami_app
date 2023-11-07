package com.example.islami.ui.home.fragments.quran

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.islami.SingleLiveEvent

class QuranFragmentContract {
    interface ViewModel{
        val state: MutableLiveData<State>
        val event: LiveData<Event>
        fun invokeAction(action:Action)
    }
    sealed class Action{

       object loadQuranTitle:Action()
        class onTitleClick(var position:Int,var name:String):Action()
    }
    sealed class State{
        class Success(var QuranTitles:List<String>):State()
    }
    sealed class Event{
        class NavigateToSoraDetails(var position:Int,var name:String):Event()
    }
}