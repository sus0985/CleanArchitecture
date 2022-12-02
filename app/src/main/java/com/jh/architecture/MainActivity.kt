package com.jh.architecture

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.jh.architecture.databinding.ActivityMainBinding
import com.jh.domain.model.Response
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lifecycleScope.launch {
            viewModel.getUsersResult.collect { response ->
                binding.progress.isVisible = response is Response.Loading

                when (response) {
                    is Response.Success -> {
                        binding.recycler.adapter = UserAdapter(response.data)
                    }
                    is Response.ApiError -> {
                        Log.d(TAG, "error: ${response.throwable}")
                    }
                    else -> Unit
                }
            }
        }
    }


    companion object {
        private const val TAG = "MainActivity"
    }
}