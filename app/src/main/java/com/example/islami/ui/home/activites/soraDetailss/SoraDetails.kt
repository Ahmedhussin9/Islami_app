package com.example.islami.ui.home.activites.soraDetailss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.islami.R
import com.example.islami.databinding.ActivitySoraDetailsBinding

import com.example.islami.ui.Constnats


class SoraDetails : AppCompatActivity() {
    lateinit var viewBinding: ActivitySoraDetailsBinding
    lateinit var viewModel: SoraDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_sora_details)
        initPrams()
        initViews()
        loadSoraDetails()
    }
    lateinit var soraName:String
    var soraIndex:Int = 0
    private fun initPrams() {
        soraIndex = intent.getIntExtra(Constnats.EXTRA_SORA_POSITION,0)
        soraName = intent.getStringExtra(Constnats.EXTRA_SORA_NAME)?:""
    }

    fun loadSoraDetails(){
        val fileContent =assets.open("$soraIndex.txt").bufferedReader().use { it.readText() }
        val lines= fileContent.trim().split("\n")
        bindVerses(lines)
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