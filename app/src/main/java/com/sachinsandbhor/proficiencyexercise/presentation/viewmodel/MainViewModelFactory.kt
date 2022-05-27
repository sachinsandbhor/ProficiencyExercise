package com.sachinsandbhor.proficiencyexercise.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sachinsandbhor.proficiencyexercise.data.repository.ArticleRepository

class MainViewModelFactory(private val articleRepository: ArticleRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(articleRepository) as T
    }
}