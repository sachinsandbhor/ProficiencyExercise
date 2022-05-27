package com.sachinsandbhor.proficiencyexercise.data.repository

import com.sachinsandbhor.proficiencyexercise.data.api.RetrofitInstance
import com.sachinsandbhor.proficiencyexercise.data.db.ArticleDatabase

class ArticleRepository(
    val db: ArticleDatabase
) {

    suspend fun getArticles() = RetrofitInstance.api.getArticles()

}