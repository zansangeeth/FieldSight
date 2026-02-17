package com.sangeeth.fieldsight

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sangeeth.fieldsight.ui.theme.FieldSightTheme
import org.json.JSONObject
import org.maplibre.compose.camera.CameraPosition
import org.maplibre.compose.camera.rememberCameraState
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.spatialk.geojson.Position

class InvestigationDetailActivity : AppCompatActivity() {
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
                                val investigationlat = jsonObject.getInt("latitude")
                                val investigationLong = jsonObject.getInt("longitude")
                                Text("Investigation Detail Screen new, $investigationId", modifier = Modifier.padding(innerPadding))

                                MaplibreMap(
                                    cameraState = rememberCameraState(

                                        firstPosition =
                                            CameraPosition(
                                                target = Position(
                                                    latitude = investigationlat.toDouble(),
                                                    longitude = investigationLong.toDouble()
                                                ), zoom = 5.0
                                            )
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}