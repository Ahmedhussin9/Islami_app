package com.example.islami.ui.home.fragments.hadeth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.Hadeth


class HadethFragmentContract {
    interface ViewModel{
        val state: MutableLiveData<State>
        val event: LiveData<Event>
        fun invokeAction(action:Action)
    }
    sealed class Action{

        object LoadHadethList:Action()
        class onHadethClick(var item:Hadeth):Action()
    }
    sealed class State{
        class Success(var Hadeth:List<com.example.domain.model.Hadeth>):State()
    }
    sealed class Event{
        class NavigateToHadethDetails(var item:Hadeth):Event()
    }
}