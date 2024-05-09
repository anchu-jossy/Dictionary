package com.example.dictionary.feature_presentation.data.locals.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionary.feature_presentation.data.locals.entity.WordInfoEntity

@Dao
interface WordInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfo(list: List<WordInfoEntity>)

    @Query("DELETE FROM wordinfoentity WHERE word IN(:list)")
    suspend fun deleteWordInfo(list: List<String>)

    @Query("SELECT * FROM wordinfoentity WHERE word LIKE '%' || :word || '%'")
    suspend fun getWordInfos(word: String):List<WordInfoEntity>
}