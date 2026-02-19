package com.sangeeth.fieldsight

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import androidx.compose.runtime.setValue

@Composable

fun InvestigationBottomSheet(
    modifier: Modifier = Modifier,
    investigationDescription: String?,
    investigationAddress: List<Double>?,
    dateAssigned: String?,
    priority: String?,
    status: String?,
    assignedBy: String?,
    attachments: String?,
    notes: String?,

) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Investigation Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(investigationDescription!!)
        var address by remember { mutableStateOf<String?>(null) }
        LaunchedEffect(Dispatchers.Main) {
            address = reverseGeocode(investigationAddress!!)
        }
        Text("Address: $address")
        Text("Assigned Date: $dateAssigned")
        Text("Priority: $priority")
        Text("Staus: $status")
        Text("Assigned By: $assignedBy")
        Text("Attachments: $attachments")
        Text("Notes: $notes")
    }

}

