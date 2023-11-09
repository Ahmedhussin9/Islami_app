package com.example.islami.ui.home.fragments.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.islami.R
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.ui.Constnats
import com.example.islami.ui.home.activites.soraDetailss.SoraDetails
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuranFragment : Fragment() {
     lateinit var viewBinding:FragmentQuranBinding
    lateinit var viewModel: QuranFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_quran,container,false)
        return viewBinding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =ViewModelProvider(this)[QuranFragmentViewModel::class.java]
        viewModel.invokeAction(QuranFragmentContract.Action.loadQuranTitle)

    }
   private val adapter = QuranTitlesAdapter()
    private fun initViews() {
        viewBinding.lifecycleOwner = this
        viewBinding.vm = viewModel
        viewBinding.recyclerView.adapter = adapter
        adapter.onItemClickListener = QuranTitlesAdapter.OnItemClickListener { position, name ->
            viewModel.invokeAction(QuranFragmentContract.Action.onTitleClick(position,name))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.invokeAction(QuranFragmentContract.Action.loadQuranTitle)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.state.observe(viewLifecycleOwner){
            when(it){
                is QuranFragmentContract.State.Success->adapter.bindItems(it.QuranTitles)
                else -> {

                }
            }
        }
        viewModel.event.observe(viewLifecycleOwner){
            when(it){
                is QuranFragmentContract.Event.NavigateToSoraDetails->{
                        navigateToSoraDetails(it.position,it.name)
                    }
                }
            }
        }
    private fun navigateToSoraDetails(position:Int,name:String) {
        val intent = Intent(context, SoraDetails::class.java)
        intent.putExtra(Constnats.EXTRA_SORA_NAME,name)
        intent.putExtra(Constnats.EXTRA_SORA_POSITION,position+1)
        startActivity(intent)
    }
}

