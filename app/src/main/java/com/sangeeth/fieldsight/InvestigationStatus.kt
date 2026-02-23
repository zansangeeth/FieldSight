package com.sangeeth.fieldsight

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun InvestigationStatus(
    statusList: List<String>,
    modifier: Modifier = Modifier,
    onStatusSelected: (String) -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedStatus by remember { mutableStateOf(statusList.firstOrNull().orEmpty()) }
    var buttonHeight by remember { mutableStateOf(0) }

    Box(
        modifier = modifier.wrapContentSize(Alignment.BottomStart)
    ) {

        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned {
                    buttonHeight = it.size.height
                },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = if (expanded)
                    MaterialTheme.colorScheme.primary
                else
                    Color.Transparent,
                contentColor = if (expanded)
                    MaterialTheme.colorScheme.onPrimary
                else
                    MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = selectedStatus)
            Spacer(Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(
                x = 0.dp,
                y = (-buttonHeight).dp
            )
        ) {
            statusList.forEach { status ->
                DropdownMenuItem(
                    text = { Text(status) },
                    onClick = {
                        selectedStatus = status
                        expanded = false
                        onStatusSelected(status)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun InvestigationBottomSheetPreview() {
    InvestigationStatus(
        statusList = listOf(
            "Pending",
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