package com.example.islami.ui.home.fragments.sebha

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.R
import com.example.islami.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    lateinit var viewbinding:FragmentSebhaBinding
    private var count  = 0
    var count_changer =0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        viewbinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewbinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadCount()
        viewbinding.count.text = count.toString()
        viewbinding.tasbehButton.setOnClickListener(){
            tasbeha()
            saveCount()
        }
        viewbinding.clearButton.setOnClickListener(){
            clear()
            saveCount()
        }
    }

    private fun clear() {
        count=0
        count_changer = 0
        viewbinding.count.text = 0.toString()
        viewbinding.tasbehButton.text ="Subhan Alah"
    }

    private fun tasbeha() {
        count++
        count_changer++
        if(count_changer in 0..33){
            viewbinding.tasbehButton.text = "Subhan Alah"
        }else if(count_changer in 34..66){
            viewbinding.tasbehButton.text = "Alhamdoulah"
        }else if(count_changer in 67..99){
            viewbinding.tasbehButton.text = "Alhu Akbar"
        }else{
            count_changer = 0
        }
        viewbinding.count.text = count.toString()
        viewbinding.sebhaBody.rotation+=30
    }
    private fun saveCount(){
        val sharedPreferences = activity?.getSharedPreferences("sharePref", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.apply {
            putInt("Count_Key",count)
            putInt("CountChanger_Key",count_changer)
        }?.apply()
    }
    private fun loadCount(){
        val sharedPreferences = activity?.getSharedPreferences("sharePref", Context.MODE_PRIVATE)
        if (sharedPreferences != null) {
            count = sharedPreferences.getInt("Count_Key",count)
            count_changer = sharedPreferences.getInt("CountChanger_Key",count_changer)
        }
    }
}