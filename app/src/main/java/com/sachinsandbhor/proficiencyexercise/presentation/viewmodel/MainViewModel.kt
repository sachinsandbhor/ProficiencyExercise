package com.sachinsandbhor.proficiencyexercise.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.sachinsandbhor.proficiencyexercise.presentation.repository.ArticleRepository

class MainViewModel(
    val articleRepository: ArticleRepository
): ViewModel() {
}