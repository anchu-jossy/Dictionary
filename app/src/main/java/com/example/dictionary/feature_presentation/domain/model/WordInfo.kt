package com.example.dictionary.feature_presentation.domain.model

data class WordInfo(  val meanings: List<Meaning>,
                 val phonetic: String,
                 val word: String) {
}