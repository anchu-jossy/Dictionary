package com.example.dictionary.feature_presentation.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dictionary.feature_presentation.domain.model.WordInfo
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun WordInfoItem(wordInfo: WordInfo, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = wordInfo.word,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(text = wordInfo.phonetic, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(16.dp))
        wordInfo.meanings.forEach {
            Text(text = it.partOfSpeech, fontWeight = FontWeight.Light)
            it.definitions.forEachIndexed { index, definition ->
                Text(
                    text = "${index + 1}.  ${definition.definition}",
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.height(8.dp))
                definition.example?.let { example ->
                    Text(text = "Example: $example")
                }
                Spacer(modifier = Modifier.height(8.dp))

            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}