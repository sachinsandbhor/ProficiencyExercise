package com.sachinsandbhor.proficiencyexercise.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Response(
    val rows: List<Row>,
    val title: String
)

@Entity(
    tableName = "articles"
)
data class Row(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val description: String,
    val imageHref: String,
    val title: String
)