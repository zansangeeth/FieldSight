package com.sangeeth.fieldsight

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
@Composable
fun InvestigationListContent(innerPadding: PaddingValues, navigateToInvestigationDetail: (investigation) -> Unit){
    LazyColumn(
        modifier = Modifier.padding(innerPadding)
    ) {
        items(investigations) { investigation ->
            InvestigationItem(investigation, navigateToInvestigationDetail)
        }
    }
}