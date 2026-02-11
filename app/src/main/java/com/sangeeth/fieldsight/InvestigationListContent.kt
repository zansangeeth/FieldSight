package com.sangeeth.fieldsight

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InvestigationListContent(innerPadding: PaddingValues){
    LazyColumn(
        modifier = Modifier.padding(innerPadding) // Important: use padding
    ) {
        items(investigations) { investigation ->
            InvestigationItem(investigation, onClickToDetailPage = {
                Log.d("MainActivity", "Investigation clicked: $it")
            })
        }
    }
}