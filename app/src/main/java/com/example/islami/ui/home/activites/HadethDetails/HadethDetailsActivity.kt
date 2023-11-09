package com.example.islami.ui.home.activites.HadethDetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import com.example.islami.R
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.ui.Constnats
import com.example.islami.ui.home.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBiding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBiding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBiding.root)
        initView()
        initParams()
        bindHadeth()
    }
    private fun initView() {
        setSupportActionBar(viewBiding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = ""
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    private fun bindHadeth() {
        viewBiding.title.text = hadeth?.title
        viewBiding.hadethLayout.hadethContent.text = hadeth?.content

    }

    var hadeth: Hadeth? = null
    private fun initParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Constnats.EXTRA_HADETH, Hadeth::class.java)

        }else{
            hadeth = intent.getParcelableExtra(Constnats.EXTRA_HADETH)as Hadeth?
        }
    }
}