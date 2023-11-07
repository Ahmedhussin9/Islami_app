package com.example.islami.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.islami.R
import com.example.islami.databinding.ActivitySplashBinding
import com.example.islami.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    lateinit var viewBinding:ActivitySplashBinding
    lateinit var viewModel : SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        subscribeToLiveData()
        viewModel.loadEvents()
    }

    private fun subscribeToLiveData() {
        viewModel.events.observe(this){
            when(it){
                SplashContract.Event.NavigateToHome -> navigateToHome()
            }
        }
    }

    private fun initViews() {
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]
    }

    private fun navigateToHome(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)},2000)
    }
}