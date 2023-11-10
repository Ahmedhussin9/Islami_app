package com.example.islami.ui.home.activites.soraDetailss

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SoraDetailsContract {
    interface ViewModel{
        val state: MutableLiveData<State>
        val event: LiveData<Event>
        fun invokeAction(action:Action)
    }
    sealed class Action{
        class loadSoraDetils():Action()
        class PassPramasToViewModel(var soraIndex:Int,var soraName:String):Action()
    }
    sealed class State{
        class Success(var SoraDetails:List<String>):State()
    }
    sealed class Event{

    }
}