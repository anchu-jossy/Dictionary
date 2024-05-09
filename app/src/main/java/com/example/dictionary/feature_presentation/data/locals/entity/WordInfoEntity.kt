package com.example.dictionary.feature_presentation.data.locals.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionary.feature_presentation.domain.model.Meaning
import com.example.dictionary.feature_presentation.domain.model.WordInfo

@Entity
class WordInfoEntity(
    val word: String,
     val phonetic: String,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
       return WordInfo(
            meanings = meanings,
            word = word,
            phonetic = phonetic
        )
    }
}