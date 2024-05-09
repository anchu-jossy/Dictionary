package com.example.dictionary.feature_presentation.domain.usecases

import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_presentation.domain.model.WordInfo
import com.example.dictionary.feature_presentation.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordInfoUsecase(val repo:WordInfoRepository) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if(word.isBlank()) {
            return flow {  }
        }
        return repo.getWordInfo(word)
    }
}