package com.sangeeth.fieldsight

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SuggestionChip
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
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
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            text = "Investigation Details",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(investigationDescription!!, style = MaterialTheme.typography.labelLarge, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(3.dp))
        var address by remember { mutableStateOf<String?>(null) }
        LaunchedEffect(Dispatchers.Main) {
            address = getInvestigationAddress(investigationAddress!!)
        }
        Text("Address: $address")
        Spacer(modifier = Modifier.height(5.dp))
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            priorityChips(priority!!)

            Text("Assigned Date: $dateAssigned")

        }
        Spacer(modifier = Modifier.height(5.dp))
        Text("Assigned By: $assignedBy")
        Spacer(modifier = Modifier.height(3.dp))
        HorizontalDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text("Attachments: $attachments")
            Button(onClick = { }) {
                Text("Upload")
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        HorizontalDivider(thickness = 2.dp)

        Column {
            Text("Notes: $notes")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Add Note") },
                )
                Button(onClick = { }) {
                    Text("Add")
                }
            }
        }
        Spacer(modifier = Modifier.height(3.dp))
        HorizontalDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.height(3.dp))
        Text("Staus: $status")
        InvestigationStatus(
            statusList = listOf(
                status.toString(),
                "In Progress",
                "Completed",
                "Closed"
            ),
            onStatusSelected = {
                Log.d("STATUS", it)
            },
            modifier = Modifier.padding(50.dp)
        )

    }
}
