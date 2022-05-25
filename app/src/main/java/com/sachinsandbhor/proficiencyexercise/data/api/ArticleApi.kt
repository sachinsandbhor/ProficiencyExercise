package com.sachinsandbhor.proficiencyexercise.data.api

import retrofit2.Response
import retrofit2.http.GET

interface ArticleApi {

    @GET("s/2iodh4vg0eortkl/facts.json")
    suspend fun getArticles(): Response<com.sachinsandbhor.proficiencyexercise.data.entities.Response>

}