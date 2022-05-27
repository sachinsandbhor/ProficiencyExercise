package com.sachinsandbhor.proficiencyexercise.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachinsandbhor.proficiencyexercise.data.entities.Response
import com.sachinsandbhor.proficiencyexercise.data.repository.ArticleRepository
import com.sachinsandbhor.proficiencyexercise.util.Resource
import kotlinx.coroutines.launch

class MainViewModel(
    private val articleRepository: ArticleRepository
): ViewModel() {

    private val articleMutableLiveData: MutableLiveData<Resource<Response>> = MutableLiveData()
    val articleLiveData: LiveData<Resource<Response>> get() = articleMutableLiveData

    init {
        getArticles()
    }

    private fun getArticles() = viewModelScope.launch {
        articleMutableLiveData.postValue(Resource.Loading())
        val response = articleRepository.getArticles()
        articleMutableLiveData.postValue(handleArticleResponse(response))
    }

    private fun handleArticleResponse(response: retrofit2.Response<Response>): Resource<Response> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


}