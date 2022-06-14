package com.krossmanzs.apparchitecture.mvi.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.krossmanzs.apparchitecture.databinding.ActivityMviBinding
import com.krossmanzs.apparchitecture.mvi.data.api.ApiHelperImpl
import com.krossmanzs.apparchitecture.mvi.data.api.RetrofitBuilder
import com.krossmanzs.apparchitecture.mvi.data.model.User
import com.krossmanzs.apparchitecture.mvi.ui.main.adapter.MainAdapter
import com.krossmanzs.apparchitecture.mvi.ui.main.intent.MainIntent
import com.krossmanzs.apparchitecture.mvi.ui.main.viewmodel.MainViewModel
import com.krossmanzs.apparchitecture.mvi.ui.main.viewstate.MainState
import com.krossmanzs.apparchitecture.mvi.util.ViewModelFactory
import kotlinx.coroutines.launch

// learn it from here
// https://blog.mindorks.com/mvi-architecture-android-tutorial-for-beginners-step-by-step-guide

class MviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMviBinding
    private var adapter = MainAdapter(arrayListOf())
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMviBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupViewModel()
        observeViewModel()
        setupClicks()
    }

    private fun setupClicks() {
        binding.buttonFetchUser.setOnClickListener {
            lifecycleScope.launch {
                mainViewModel.userIntent.send(MainIntent.FetchUser)
            }
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            mainViewModel.state.collect {
                when(it) {
                    is MainState.Idle -> {

                    }
                    is MainState.Loading -> {
                        binding.buttonFetchUser.visibility = View.GONE
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is MainState.Users -> {
                        binding.progressBar.visibility = View.GONE
                        binding.buttonFetchUser.visibility = View.GONE
                        renderList(it.user)
                    }
                    is MainState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.buttonFetchUser.visibility = View.VISIBLE
                        Toast.makeText(this@MviActivity, it.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun renderList(users: List<User>) {
        binding.recyclerView.visibility = View.VISIBLE
        users.let { listOfUsers ->
            listOfUsers.let {
                adapter.addData(it)
            }
        }
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(
                ApiHelperImpl(
                    RetrofitBuilder.apiService
                )
            )
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.run {
            addItemDecoration(
                DividerItemDecoration(
                    binding.recyclerView.context,
                    (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
        }
        binding.recyclerView.adapter = adapter
    }


}