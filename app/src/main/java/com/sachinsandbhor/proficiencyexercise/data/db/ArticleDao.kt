package com.sachinsandbhor.proficiencyexercise.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sachinsandbhor.proficiencyexercise.data.entities.Row

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(row: Row): Long

    @Query("SELECT * FROM articles")
    fun getArticles(): LiveData<List<Row>>

    @Delete
    suspend fun deleteArticle(row: Row)
}