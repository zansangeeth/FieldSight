package com.sangeeth.fieldsight

import com.mapbox.geojson.Point
import com.mapbox.search.ApiType
import com.mapbox.search.ResponseInfo
import com.mapbox.search.ReverseGeoOptions
import com.mapbox.search.SearchCallback
import com.mapbox.search.SearchEngine
import com.mapbox.search.SearchEngineSettings
import com.mapbox.search.result.SearchResult
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun reverseGeocode(latLng: List<Double>): String? =
    suspendCancellableCoroutine { continuation ->

        val latitude = latLng[0]
        val longitude = latLng[1]

        val searchEngine = SearchEngine.createSearchEngineWithBuiltInDataProviders(
            ApiType.SEARCH_BOX,
            SearchEngineSettings()
        )

        val options = ReverseGeoOptions(
            center = Point.fromLngLat(longitude, latitude),
            limit = 1
        )

        val task = searchEngine.search(options, object : SearchCallback {

            override fun onResults(
                results: List<SearchResult>,
                responseInfo: ResponseInfo
            ) {
                val address = results.firstOrNull()
                    ?.address
                    ?.formattedAddress()

                continuation.resume(address)
            }

            override fun onError(e: Exception) {
                continuation.resume(null)
            }
        })

        continuation.invokeOnCancellation {
            task.cancel()
        }
    }
