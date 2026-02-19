package com.sangeeth.fieldsight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.Marker

@Composable
fun InvestigationMap(
    investigationLong: Double,
    investigationLat: Double
) {
    MapboxMap(
        modifier = Modifier.fillMaxSize(),
        mapViewportState = rememberMapViewportState {
            setCameraOptions {
                zoom(5.0)
                center(
                    Point.fromLngLat(
                        investigationLong,
                        investigationLat
                    )
                )
                pitch(0.0)
                bearing(0.0)
            }
        }
    ) {
        Marker(
            point = Point.fromLngLat(
                investigationLong,
                investigationLat
            ),
            color = Color(255, 0, 0)
        )
    }
}
