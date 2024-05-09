package com.example.dictionary.feature_presentation.data.remote.dto

import com.example.dictionary.feature_presentation.data.locals.entity.WordInfoEntity
import com.example.dictionary.feature_presentation.domain.model.WordInfo

data class WordInfoDto(

    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            phonetic = phonetic,
            word = word
        )
    }

}