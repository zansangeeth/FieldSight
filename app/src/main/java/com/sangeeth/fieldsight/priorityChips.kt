package com.sangeeth.fieldsight

import android.util.Log
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun priorityChips(priority: String){
    SuggestionChip(
        onClick = { Log.d("Suggestion chip", "hello world") },
        label = { Text(priority) }
    )
}
