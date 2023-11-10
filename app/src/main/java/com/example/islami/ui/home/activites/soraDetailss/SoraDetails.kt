package com.example.islami.ui.home.activites.soraDetailss
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.islami.R
import com.example.islami.databinding.ActivitySoraDetailsBinding

import com.example.islami.ui.Constnats
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SoraDetails : AppCompatActivity() {
    lateinit var viewBinding: ActivitySoraDetailsBinding
    lateinit var viewModel: SoraDetailsViewModel
    lateinit var soraName:String
    var soraIndex:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_sora_details)
        initPrams()
        initViews()
        subscribeToLiveData()
        viewModel.invokeAction(SoraDetailsContract.Action.PassPramasToViewModel(soraIndex,soraName))
        viewModel.invokeAction(SoraDetailsContract.Action.loadSoraDetils())
    }

    private fun subscribeToLiveData() {
        viewModel.state.observe(this){
            when(it){
                is SoraDetailsContract.State.Success->bindVerses(it.SoraDetails)
            }
        }
    }

    private fun initPrams() {
        soraIndex = intent.getIntExtra(Constnats.EXTRA_SORA_POSITION,0)
        soraName = intent.getStringExtra(Constnats.EXTRA_SORA_NAME)?:""
    }

    lateinit var adapter: VersesAdapter
    private fun bindVerses(lines: List<String>) {
        adapter = VersesAdapter(lines)
        viewBinding.content.versersRv.adapter = adapter
    }
    private fun initViews() {
        viewModel = ViewModelProvider(this)[SoraDetailsViewModel::class.java]
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setTitle("")
        viewBinding.title.text = soraName

    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}