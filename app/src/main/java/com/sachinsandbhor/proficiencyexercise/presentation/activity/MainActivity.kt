package com.sachinsandbhor.proficiencyexercise.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sachinsandbhor.proficiencyexercise.R
import com.sachinsandbhor.proficiencyexercise.data.db.ArticleDatabase
import com.sachinsandbhor.proficiencyexercise.presentation.repository.ArticleRepository
import com.sachinsandbhor.proficiencyexercise.presentation.viewmodel.MainViewModel
import com.sachinsandbhor.proficiencyexercise.presentation.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val articleRepository = ArticleRepository(ArticleDatabase(this))
        val mainViewModelFactory = MainViewModelFactory(articleRepository)
        viewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)
    }
}