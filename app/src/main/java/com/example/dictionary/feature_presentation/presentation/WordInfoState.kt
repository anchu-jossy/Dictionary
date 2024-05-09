package com.example.dictionary.feature_presentation.presentation

import com.example.dictionary.feature_presentation.domain.model.WordInfo


data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)