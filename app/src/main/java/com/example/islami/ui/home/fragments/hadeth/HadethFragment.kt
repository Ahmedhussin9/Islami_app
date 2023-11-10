package com.example.islami.ui.home.fragments.hadeth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.islami.databinding.FragmentHadethBinding
import com.example.islami.ui.Constnats
import com.example.islami.ui.home.activites.HadethDetails.HadethDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HadethFragment : Fragment() {
    lateinit var viewBinding:FragmentHadethBinding
    lateinit var viewModel: HadethFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHadethBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.invokeAction(HadethFragmentContract.Action.LoadHadethList)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.state.observe(viewLifecycleOwner){
            when (it){
                is HadethFragmentContract.State.Success-> adapter.bindItems(it.Hadeth)
            }
        }
        viewModel.event.observe(viewLifecycleOwner){
            when (it){
                is HadethFragmentContract.Event.NavigateToHadethDetails->showHadethDetails(it.item)
            }
        }
    }

    private fun showHadethDetails(item: com.example.domain.model.Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(Constnats.EXTRA_HADETH,item)
        startActivity(intent)
    }
    lateinit var adapter: HadethRecyclerViewAdapter
    private fun initViews() {
        viewModel = ViewModelProvider(this)[HadethFragmentViewModel::class.java]
        adapter = HadethRecyclerViewAdapter(null)
        adapter.onItemClickListener=HadethRecyclerViewAdapter.OnItemClickListener{
                position, item ->
            showHadethDetails(item)
        }
        viewBinding.recyclerView.adapter = adapter
    }
    }
