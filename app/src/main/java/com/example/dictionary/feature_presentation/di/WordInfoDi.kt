package com.example.dictionary.feature_presentation.di

import android.app.Application
import androidx.room.Room
import com.example.dictionary.feature_presentation.data.locals.database.WordInfoDatabase
import com.example.dictionary.feature_presentation.data.remote.DictionaryAPI
import com.example.dictionary.feature_presentation.data.repository.WordInfoRepositoryImpl
import com.example.dictionary.feature_presentation.data.util.Converters
import com.example.dictionary.feature_presentation.data.util.GsonParser
import com.example.dictionary.feature_presentation.domain.repository.WordInfoRepository
import com.example.dictionary.feature_presentation.domain.usecases.WordInfoUsecase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoDi {

    @Provides
    @Singleton
    fun provideWordUseCase(repository: WordInfoRepository): WordInfoUsecase {
        return WordInfoUsecase(repository)
    }


    @Provides
    @Singleton
    fun provideWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryAPI
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryAPI {
        return Retrofit.Builder()
            .baseUrl(DictionaryAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }
}