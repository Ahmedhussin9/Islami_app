package com.example.islami.ui.home.fragments.hadeth

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.R
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.ui.Constnats
import com.example.islami.ui.home.activites.HadethDetails.HadethDetailsActivity
import com.example.islami.ui.home.model.Hadeth

class HadethFragment : Fragment() {
    lateinit var viewBinding:FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHadethBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadHadtehFile()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onStart() {
        super.onStart()
        bindHadethList()
    }
    private fun bindHadethList() {
        adapter.bindItems(hadethList)
    }

    private fun showHadethDetails(item: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(Constnats.EXTRA_HADETH,item)
        startActivity(intent)
    }
    lateinit var adapter: HadethRecyclerViewAdapter

    private fun initViews() {
        adapter = HadethRecyclerViewAdapter(null)
        adapter.onItemClickListener=HadethRecyclerViewAdapter.OnItemClickListener{
                position, item ->
            showHadethDetails(item)
        }
        viewBinding.recyclerView.adapter = adapter
    }
    val hadethList = mutableListOf<Hadeth>()
    private fun loadHadtehFile() {
        val fileContent =requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val singleHadethList = fileContent.trim().split("#")
        singleHadethList.forEach { elemnt->
            val lines = elemnt.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(title,content)
            hadethList.add(hadeth)
        }
    }
}