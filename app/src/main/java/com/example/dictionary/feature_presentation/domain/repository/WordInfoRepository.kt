package com.example.dictionary.feature_presentation.domain.repository

import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_presentation.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {
    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}