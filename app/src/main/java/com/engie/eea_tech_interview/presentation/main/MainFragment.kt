package com.engie.eea_tech_interview.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.engie.eea_tech_interview.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private var currentBinding : FragmentMainBinding? = null
    private val ui get() = currentBinding!!

    private val mainViewModel : MainViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        currentBinding = FragmentMainBinding.inflate(inflater)
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.onTriggeredEvent(MainViewEvent.GetSearchResult("u"))

        getSearchResultSubscriber ()
    }


    private fun getSearchResultSubscriber () {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainViewModel.getSearchResultViewState.collectLatest {state->
                if (state.error != "") {
                    Toast.makeText(requireContext(), "${state.error}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Herree: ${state.searchResult?.results}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        currentBinding = null
    }
}