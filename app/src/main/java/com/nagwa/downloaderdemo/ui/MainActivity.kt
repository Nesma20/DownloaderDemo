package com.nagwa.downloaderdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.nagwa.downloaderdemo.R
import com.nagwa.downloaderdemo.databinding.ActivityMainBinding
import com.nagwa.downloaderdemo.model.FilesData
import com.nagwa.downloaderdemo.model.Status
import com.nagwa.downloaderdemo.ui.adapters.FilesListAdapter
import com.nagwa.downloaderdemo.utils.MyApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as MyApplication).appComponent.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        observeData()
    }

    fun observeData() {
        mainViewModel.filesData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    hideProgress()
                    hideErrorText()
                    var adapter = FilesListAdapter(it.data as ArrayList<FilesData>)
                    binding.filesRecyclerView.adapter = adapter
                    binding.filesRecyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    showProgress()
                    hideRecyclerView()
                    hideErrorText()
                }
                Status.ERROR -> {
                    hideProgress()
                    hideRecyclerView()
                    it.message?.let { it1 -> showErrorText(it1) }
                }
            }
        })
    }

    private fun showErrorText(message: String) {
        binding.noDataFoundTxtView.text = message
        binding.noDataFoundTxtView.visibility = View.VISIBLE
    }

    private fun hideRecyclerView() {
        binding.filesRecyclerView.visibility = View.GONE
    }

    private fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideErrorText() {
        binding.noDataFoundTxtView.visibility = View.GONE
    }

    private fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }
}