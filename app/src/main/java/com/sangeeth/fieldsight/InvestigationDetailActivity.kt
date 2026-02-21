package com.sangeeth.fieldsight

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sangeeth.fieldsight.ui.theme.FieldSightTheme
import org.json.JSONObject

class InvestigationDetailActivity : AppCompatActivity() {
 @OptIn(ExperimentalMaterial3Api::class)
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            FieldSightTheme {
                NavHost(navController, startDestination = "investigation_detail"){
                    composable("investigation_detail") {
                        TopBarNavigationOnBack(
                            navigationBack = { finish() },
                            topBarTitle = "Investigation Detail",
                            content = { innerPadding ->
                                val investigation = intent.getStringExtra("investigation")
                                val jsonObject = JSONObject(investigation)
                                Log.i("Investigation Detail Screen", jsonObject.toString())
                                val investigationId = jsonObject.getInt("id")
                                val investigationlat = jsonObject.getDouble("latitude")
                                val investigationLong = jsonObject.getDouble("longitude")
                                val investigationPoint = listOf(investigationlat, investigationLong)
                                Text("Investigation Detail Screen new, $investigationId", modifier = Modifier.padding(innerPadding))

                                val scaffoldState = rememberBottomSheetScaffoldState()

                                BottomSheetScaffold(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                    scaffoldState = scaffoldState,
                                    sheetContent = {
                                        InvestigationBottomSheet(
                                            investigationDescription = jsonObject.getString("description"),
                                            investigationAddress = investigationPoint,
                                            dateAssigned = jsonObject.getString("dateAssigned"),
                                            priority = jsonObject.getString("priority"),
                                            status = jsonObject.getString("status"),
                                            assignedBy = jsonObject.getString("assignedBy"),
                                            attachments = jsonObject.getString("attachments"),
                                            notes = jsonObject.getString("notes"),
                                        )
                                    }
                                ) {
                                    InvestigationMap(
                                        investigationLat = investigationlat,
                                        investigationLong = investigationLong
                                    )
                                }

                            }
                        )
                    }
                }
            }
        }
    }
}