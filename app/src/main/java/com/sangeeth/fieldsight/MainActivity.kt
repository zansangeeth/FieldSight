package com.sangeeth.fieldsight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sangeeth.fieldsight.ui.theme.FieldSightTheme

val investigations = listOf(
    investigation(1, "Gas odor reported near residential block", "2026-01-02", Priority.HIGH, Status.ASSIGNED, 40.7282, -73.7949),
    investigation(2, "Routine pipeline inspection", "2026-01-03", Priority.LOW, Status.IN_PROGRESS, 40.7420, -73.9185),
    investigation(3, "Commercial building gas alarm", "2026-01-03", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7061, -73.9969),
    investigation(4, "Meter malfunction complaint", "2026-01-04", Priority.MEDIUM, Status.PAUSED, 40.6782, -73.9442),
    investigation(5, "Gas smell in basement", "2026-01-04", Priority.HIGH, Status.IN_PROGRESS, 40.7614, -73.8293),

    investigation(6, "Scheduled safety audit", "2026-01-05", Priority.LOW, Status.RESOLVED, 40.7898, -73.1349),
    investigation(7, "Public report of hissing sound", "2026-01-05", Priority.MEDIUM, Status.ASSIGNED, 40.7419, -73.7154),
    investigation(8, "Emergency call from restaurant", "2026-01-06", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7336, -73.5868),
    investigation(9, "Old pipeline pressure drop", "2026-01-06", Priority.MEDIUM, Status.IN_PROGRESS, 40.7851, -73.4287),
    investigation(10, "Construction-related gas concern", "2026-01-07", Priority.MEDIUM, Status.NO_GAS_LEAK_FOUND, 40.7259, -73.2454),

    investigation(11, "Tenant reports recurring odor", "2026-01-07", Priority.HIGH, Status.IN_PROGRESS, 40.7543, -73.6187),
    investigation(12, "Preventive infrastructure check", "2026-01-08", Priority.LOW, Status.RESOLVED, 40.8096, -73.0205),
    investigation(13, "Utility sensor alert", "2026-01-08", Priority.HIGH, Status.ASSIGNED, 40.6951, -73.7312),
    investigation(14, "School building inspection", "2026-01-09", Priority.MEDIUM, Status.PAUSED, 40.8122, -73.4678),
    investigation(15, "Gas odor near subway entrance", "2026-01-09", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7129, -73.9067),

    investigation(16, "Annual compliance inspection", "2026-01-10", Priority.LOW, Status.RESOLVED, 40.7810, -73.5621),
    investigation(17, "Pressure irregularity detected", "2026-01-10", Priority.MEDIUM, Status.IN_PROGRESS, 40.8467, -73.3875),
    investigation(18, "Warehouse gas alarm", "2026-01-11", Priority.HIGH, Status.NEED_SUPPORT, 40.7364, -73.1862),
    investigation(19, "Resident complaint after storm", "2026-01-11", Priority.MEDIUM, Status.ASSIGNED, 40.6689, -73.8523),
    investigation(20, "Gas line vibration report", "2026-01-12", Priority.MEDIUM, Status.NO_GAS_LEAK_FOUND, 40.8194, -73.6704),

    investigation(21, "Emergency services referral", "2026-01-12", Priority.HIGH, Status.IN_PROGRESS, 40.7074, -74.0113),
    investigation(22, "Retail store alarm triggered", "2026-01-13", Priority.MEDIUM, Status.GAS_LEAK_FOUND, 40.7589, -73.9851),
    investigation(23, "Apartment building inspection", "2026-01-13", Priority.MEDIUM, Status.PAUSED, 40.7369, -73.9916),
    investigation(24, "Preventive valve check", "2026-01-14", Priority.LOW, Status.RESOLVED, 40.8005, -73.9590),
    investigation(25, "Gas odor reported by passerby", "2026-01-14", Priority.HIGH, Status.ASSIGNED, 40.6928, -73.9903),

    investigation(26, "Pipeline maintenance follow-up", "2026-01-15", Priority.LOW, Status.IN_PROGRESS, 40.8291, -73.5156),
    investigation(27, "Community center gas alarm", "2026-01-15", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7512, -73.7769),
    investigation(28, "Routine inspection – residential", "2026-01-16", Priority.LOW, Status.RESOLVED, 40.8884, -73.3817),
    investigation(29, "Odor complaint near marina", "2026-01-16", Priority.MEDIUM, Status.IN_PROGRESS, 40.9046, -73.1281),
    investigation(30, "Pressure sensor anomaly", "2026-01-17", Priority.HIGH, Status.NEED_SUPPORT, 40.7836, -73.9661),

    investigation(31, "Gas leak suspicion in garage", "2026-01-17", Priority.HIGH, Status.ASSIGNED, 40.7321, -73.8645),
    investigation(32, "Follow-up inspection after repair", "2026-01-18", Priority.LOW, Status.RESOLVED, 40.7098, -73.8146),
    investigation(33, "School safety inspection", "2026-01-18", Priority.MEDIUM, Status.IN_PROGRESS, 40.8459, -73.7028),
    investigation(34, "Subsurface gas reading elevated", "2026-01-19", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7648, -73.7391),
    investigation(35, "Utility crew referral", "2026-01-19", Priority.MEDIUM, Status.PAUSED, 40.7873, -73.6504),

    investigation(36, "Gas odor reported by business", "2026-01-20", Priority.HIGH, Status.IN_PROGRESS, 40.7216, -73.8774),
    investigation(37, "Pipeline corrosion check", "2026-01-20", Priority.MEDIUM, Status.NO_GAS_LEAK_FOUND, 40.8702, -73.4479),
    investigation(38, "Emergency alarm – residential", "2026-01-21", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7455, -73.9032),
    investigation(39, "Valve integrity inspection", "2026-01-21", Priority.LOW, Status.RESOLVED, 40.8127, -73.5862),
    investigation(40, "Construction site gas concern", "2026-01-22", Priority.MEDIUM, Status.ASSIGNED, 40.7792, -73.8218),

    investigation(41, "Gas odor near shopping plaza", "2026-01-22", Priority.HIGH, Status.IN_PROGRESS, 40.7654, -73.5321),
    investigation(42, "Routine compliance audit", "2026-01-23", Priority.LOW, Status.RESOLVED, 40.8899, -73.2459),
    investigation(43, "Pressure drop alert", "2026-01-23", Priority.MEDIUM, Status.IN_PROGRESS, 40.7008, -73.9199),
    investigation(44, "Apartment gas alarm", "2026-01-24", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7287, -73.9846),
    investigation(45, "Follow-up after storm damage", "2026-01-24", Priority.MEDIUM, Status.NEED_SUPPORT, 40.8234, -73.3047),

    investigation(46, "Preventive inspection – industrial", "2026-01-25", Priority.LOW, Status.RESOLVED, 40.9181, -73.0864),
    investigation(47, "Resident complaint – recurring odor", "2026-01-25", Priority.HIGH, Status.ASSIGNED, 40.7449, -73.7033),
    investigation(48, "Gas meter anomaly", "2026-01-26", Priority.MEDIUM, Status.IN_PROGRESS, 40.8665, -73.5968),
    investigation(49, "Emergency services escalation", "2026-01-26", Priority.HIGH, Status.GAS_LEAK_FOUND, 40.7112, -73.9576),
    investigation(50, "Final clearance inspection", "2026-01-27", Priority.LOW, Status.RESOLVED, 40.8041, -73.4832)
)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FieldSightTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Field Sight") }
                        )
                    }
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.padding(innerPadding) // Important: use padding
                    ) {
                        items(investigations) { investigation ->
                            InvestigationItem(investigation)
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun InvestigationItem(
    investigation: investigation
) {
    Card(
        modifier = Modifier.padding(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Investigation #${investigation.id}",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = investigation.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Priority: ${investigation.priority}",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = investigation.status.name.replace("_", " "),
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Assigned: ${investigation.dateAssigned}",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}


