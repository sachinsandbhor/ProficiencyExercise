package com.sachinsandbhor.proficiencyexercise.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sachinsandbhor.proficiencyexercise.R
import com.sachinsandbhor.proficiencyexercise.data.db.ArticleDatabase
import com.sachinsandbhor.proficiencyexercise.presentation.adapter.ArticleAdapter
import com.sachinsandbhor.proficiencyexercise.data.repository.ArticleRepository
import com.sachinsandbhor.proficiencyexercise.presentation.viewmodel.MainViewModel
import com.sachinsandbhor.proficiencyexercise.presentation.viewmodel.MainViewModelFactory
import com.sachinsandbhor.proficiencyexercise.util.Resource
import kotlinx.android.synthetic.main.activity_main.*

private val TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val articleRepository = ArticleRepository(ArticleDatabase(this))
        val mainViewModelFactory = MainViewModelFactory(articleRepository)
        viewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        setupRecyclerView()
        setObserver()
    }

    private fun setObserver() {
        viewModel.articleLiveData.observe(this) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { articleResponse ->
                        articleAdapter.differ.submitList(articleResponse.rows)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e(TAG, "setObserver : $message")
                    }
                }
                is Resource.Loading -> {

                }
            }
        }
    }

    private fun setupRecyclerView() {
        articleAdapter = ArticleAdapter()
        rv_article_list.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}