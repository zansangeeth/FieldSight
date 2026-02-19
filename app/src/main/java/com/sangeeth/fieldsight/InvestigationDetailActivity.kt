package com.sangeeth.fieldsight

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.Marker
import com.mapbox.maps.extension.compose.style.standard.MapboxStandardStyle
import com.sangeeth.fieldsight.ui.theme.FieldSightTheme
import org.json.JSONObject

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


                                MapboxMap(
                                    Modifier.fillMaxSize(),
                                    mapViewportState = rememberMapViewportState {
                                        setCameraOptions {
                                            zoom(5.0)
                                            center(Point.fromLngLat(investigationLong.toDouble(), investigationlat.toDouble()))
                                            pitch(0.0)
                                            bearing(0.0)
                                        }
                                    },
                                ){
                                    Marker(
                                        point = Point.fromLngLat(investigationLong.toDouble(), investigationlat.toDouble()),
                                        color = Color(255, 0, 0)
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