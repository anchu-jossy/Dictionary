package com.example.dictionary.feature_presentation.data.locals.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionary.feature_presentation.data.locals.dao.WordInfoDao
import com.example.dictionary.feature_presentation.data.locals.entity.WordInfoEntity
import com.example.dictionary.feature_presentation.data.util.Converters



@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val dao: WordInfoDao
}