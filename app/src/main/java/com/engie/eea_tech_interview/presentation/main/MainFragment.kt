package com.engie.eea_tech_interview.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.engie.eea_tech_interview.databinding.FragmentMainBinding
import com.engie.eea_tech_interview.presentation.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.android.inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var currentBinding : FragmentMainBinding? = null
    private val ui get() = currentBinding!!

    private val mainViewModel : MainViewModel by viewModels()

    private lateinit var mainAdapter : MainAdapter

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

        initRecyclerView ()
        mainViewModel.onTriggeredEvent(MainViewEvent.GetSearchResult("james bond"))

        getSearchResultSubscriber ()
    }


    private fun getSearchResultSubscriber () {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            mainViewModel.getSearchResultViewState.collectLatest {state->
                if (state.error != "") {
                    Toast.makeText(requireContext(), "${state.error}", Toast.LENGTH_SHORT).show()
                } else {
                    state.searchResult?.let {movies->
                       // ui.check.text = movies.toString()
                       // Toast.makeText(requireContext(), "Herree: ${movies}", Toast.LENGTH_SHORT).show()
                        mainAdapter.submitList(movies)
                    }

                }
            }
        }
    }

    private fun initRecyclerView () {
        mainAdapter = MainAdapter(
            onMovieClicked = { movie ->

            }
        )

        ui.apply {
            recyclerViewMovie.apply {
                adapter = mainAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        currentBinding = null
    }
}